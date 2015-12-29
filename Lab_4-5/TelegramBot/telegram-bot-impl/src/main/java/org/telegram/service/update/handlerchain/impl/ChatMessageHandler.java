package org.telegram.service.update.handlerchain.impl;

import telegram.impl.HistoryService;
import telegram.HistoryRecord;
import telegram.domain.Update;
import org.telegram.service.update.handlerchain.UpdateHandler;

import java.util.Date;

/**
 * Created on 29.12.2015.
 */
public class ChatMessageHandler implements UpdateHandler {

    private UpdateHandler nextHandler;
    private HistoryService service;

    public ChatMessageHandler(HistoryService service) {

        this.service = service;
    }

    @Override
    public void setNext(UpdateHandler next) {
        nextHandler = next;
    }

    @Override
    public void handle(Update update) {

        //push events to history

        HistoryRecord record = new HistoryRecord();
        record.setUser(update.getMessage().getFrom());
        record.setDate(new Date(update.getMessage().getDate()));

        service.insertRecord(update.getMessage().getChat().getId(), record);

        if(nextHandler != null)
            nextHandler.handle(update);
    }
}
