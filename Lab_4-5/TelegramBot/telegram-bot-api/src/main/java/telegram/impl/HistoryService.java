package telegram.impl;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import telegram.BotChatHistory;
import telegram.HistoryRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 29.12.2015.
 */
public class HistoryService {

    private BotChatHistory history;

    public HistoryService(BotChatHistory history) {

        this.history = history;
    }

    public void insertRecord(int chatID, HistoryRecord record) {
        history.addRecord(chatID,record);
    }

    public Map<String, Integer> getTopUsers(int chatID) {

        Map<String, Integer> dailyStats = new HashMap<>();
        List<HistoryRecord> chatHistory = history.getChatHistory(chatID);

        for(HistoryRecord record : chatHistory) {
            String userName = record.getUser().getUserName();
            Integer count = dailyStats.containsKey(userName) ? dailyStats.get(userName) + 1 : 1;
            dailyStats.put(userName,count);
        }

        dailyStats.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed());

        return dailyStats;
    }


    public Map<Interval,Double> getChatActivity(int chatID, List<Interval> timespans) {

        Map<Interval,Double> chatActivity = new HashMap<>();

        List<HistoryRecord> chatHistory = history.getChatHistory(chatID);

        //this is an ugly way, to fix
        for(Interval tmspan : timespans){
            Integer msgNum = 0;
            for(HistoryRecord record : chatHistory) {
                DateTime date = new DateTime(record.getDate());
                if(tmspan.contains(date)) {
                    msgNum++;
                }
            }
            chatActivity.put(tmspan, msgNum.doubleValue() / (tmspan.toDurationMillis() / 1000 / 60));
        }

        return chatActivity;

    }


    public void cleanHistory() {
        history.doCleanup();
    }

}
