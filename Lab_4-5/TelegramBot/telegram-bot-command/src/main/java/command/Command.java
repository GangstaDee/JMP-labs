package command;

import telegram.api.BotApi;
import telegram.impl.HistoryService;

/**
 * Created on 20.12.2015.
 */
public abstract class Command implements Cloneable{

    protected String text;
    protected Integer chatID;
    protected BotApi botApi;
    protected HistoryService historyService;

    public void setText(String text) {

        this.text = text;
    }

    public void setChatID(Integer chatID) {

        this.chatID = chatID;
    }

    public void setBotApi(BotApi botApi) {

        this.botApi = botApi;
    }

    public void setHistoryService(HistoryService service) {

        this.historyService = service;
    }

    public abstract String getAction();

    public abstract void execute();

    @Override
    protected Command clone() throws CloneNotSupportedException {

        //!!!!!!
        Command clone = (Command)super.clone();
        clone.setBotApi(this.botApi);
        clone.setHistoryService(this.historyService);
        return clone;
    }
}
