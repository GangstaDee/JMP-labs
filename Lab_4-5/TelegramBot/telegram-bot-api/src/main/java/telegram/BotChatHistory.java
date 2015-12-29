package telegram;

import java.util.*;

/**
 * Created on 12/29/2015.
 */
public class BotChatHistory {

    private static Map<Integer, List<HistoryRecord>> history = new HashMap<>();

    public void addRecord(Integer chatID, HistoryRecord entry) {

        List chatHistory = history.get(chatID);
        if(chatHistory == null) {
            chatHistory = new ArrayList<>();
            history.put(chatID,chatHistory);
        }
        chatHistory.add(entry);
    }

    public List<HistoryRecord> getChatHistory(Integer chatID) {
        List chatHistory = history.get(chatID);
        if(chatHistory == null) {
            chatHistory = new ArrayList<>();
        }
        return Collections.unmodifiableList(chatHistory);
    }

    public synchronized void doCleanup() {
        history = new HashMap<>();
    }

}
