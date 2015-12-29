package org.telegram.service.update.handlerchain;

import telegram.domain.Update;

/**
 * Created on 20.12.2015.
 */
public interface UpdateHandler {

    void handle(Update update);

    void setNext(UpdateHandler next);
}
