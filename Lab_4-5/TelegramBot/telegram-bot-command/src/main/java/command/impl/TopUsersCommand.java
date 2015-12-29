package command.impl;

import command.Command;

import java.util.Map;

/**
 * Created on 29.12.2015.
 */
public class TopUsersCommand extends Command {

    @Override
    public String getAction() {

        return "/top";
    }

    @Override
    public void execute() {

        Map<String, Integer> dailyStats = historyService.getTopUsers(chatID);
        for(Map.Entry entry : dailyStats.entrySet()) {
            botApi.sendMessage(chatID, "user: " + entry.getKey() + ", messages: " + entry.getValue());
        }
    }

}
