package command.impl;

import command.Command;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 29.12.2015.
 */
public class ChatActivityCommand extends Command {

    private List<Interval> timespans = new ArrayList<>();

    @Override
    public String getAction() {

        return "/activity";
    }

    @Override
    public void execute() {

        //fill timespans
        DateTime startDate = new DateTime().withTimeAtStartOfDay();
        Interval interval = new Interval(startDate, startDate.plusHours(3));
        timespans.add(interval);
        interval = interval.withEnd(interval.getEnd().plusHours(3));
        timespans.add(interval);

        Map<Interval, Double> activityMap = historyService.getChatActivity(chatID, timespans);

        for (Map.Entry entry : activityMap.entrySet()) {
            botApi.sendMessage(chatID, ((Interval) entry.getKey()).getStart().toLocalTime() +
                    " - " + ((Interval) entry.getKey()).getEnd().toLocalTime() +
                    " - " + entry.getValue() + " messages/minute ");
        }
    }
}
