package org.telegram.bot.main;

import org.telegram.bot.controller.TelegramBotController;
import org.telegram.bot.update.consumer.LongPoolingUpdateConsumer;
import telegram.TelegramBot;
import telegram.api.BotApi;

/**
 * Created on 19.12.2015.
 */
public class Runner {

    public static void main(String[] args) {

        TelegramBot bot = new TelegramBot("#############");
        BotApi botApi = bot.create();

        TelegramBotController controller = new TelegramBotController(
                    new LongPoolingUpdateConsumer(botApi));
        controller.start();
    }
}
