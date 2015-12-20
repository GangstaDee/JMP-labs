package org.telegram.bot.update.handler;

import org.telegram.bot.command.Command;
import org.telegram.bot.command.CommandFactory;
import org.telegram.bot.command.CommandParser;
import telegram.api.BotApi;
import telegram.domain.Update;

/**
 * Created on 20.12.2015.
 */
public class UpdateHandler {

    private BotApi botApi;

    public UpdateHandler(BotApi botApi) {

        this.botApi = botApi;
    }

    public void handle(Update update) {

        String updateMsg = update.getMessage().getText();
        String command = CommandParser.parse(updateMsg);
        if(command == null)
            return;

        Command action = CommandFactory.getCommand(command);
        action.setBotApi(botApi);
        action.setChatID(update.getMessage().getChat().getId());
        action.setText(updateMsg.replaceAll(command,""));
        action.execute();
    }
}
