package org.telegram.app.main;

import command.CommandFactory;
import command.impl.TerminateCommand;
import command.impl.YoutubeSearchCommand;
import org.telegram.service.controller.TelegramBotController;
import org.telegram.service.timer.HistoryCleanupTimer;
import org.telegram.service.timer.process.JarProcessor;
import org.telegram.service.update.consumer.LongPoolingUpdateConsumer;
import org.telegram.service.timer.FolderWatchService;
import org.telegram.service.update.handlerchain.UpdateHandler;
import org.telegram.service.update.handlerchain.impl.BotCommandHandler;
import org.telegram.service.update.handlerchain.impl.ChatMessageHandler;
import telegram.BotChatHistory;
import telegram.TelegramBot;
import telegram.api.BotApi;
import telegram.impl.HistoryService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 19.12.2015.
 */
public class Application {

    public static void main(String[] args) {

        initCommands();

        ExecutorService execService = Executors.newFixedThreadPool(1);
        FolderWatchService watchService = new FolderWatchService();
        watchService.addChangesProcessor(new JarProcessor());
        execService.submit(watchService);

        TelegramBot bot = new TelegramBot("########");
        BotApi botApi = bot.create();

        HistoryService service = new HistoryService(new BotChatHistory());
        new HistoryCleanupTimer(service);

        UpdateHandler handler = initHandlerChain(botApi, service);
        TelegramBotController controller = new TelegramBotController(
                    new LongPoolingUpdateConsumer(botApi, handler));
        controller.start();

    }

    private static void initCommands() {

        YoutubeSearchCommand youtube = new YoutubeSearchCommand();
        TerminateCommand quit = new TerminateCommand();
        CommandFactory.addCommand(youtube.getAction(), youtube);
        CommandFactory.addCommand(quit.getAction(), youtube);
    }

    private static UpdateHandler initHandlerChain(BotApi botApi, HistoryService service) {

        UpdateHandler chatHandler = new ChatMessageHandler(service);
        UpdateHandler botHandler = new BotCommandHandler(botApi, service);
        botHandler.setNext(chatHandler);
        return botHandler;
    }
}