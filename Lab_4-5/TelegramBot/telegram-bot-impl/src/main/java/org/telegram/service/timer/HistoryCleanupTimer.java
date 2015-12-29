package org.telegram.service.timer;

import org.joda.time.DateTime;
import telegram.impl.HistoryService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created on 29.12.2015.
 */
public class HistoryCleanupTimer {

    private HistoryService service;
    Timer timer;

    public HistoryCleanupTimer(HistoryService service) {
        this.service = service;
        timer = new Timer();
        timer.schedule(new CleanupTask(), new DateTime().withTimeAtStartOfDay().toDate(),
                1000 * 60 * 60 * 24);
    }

    class CleanupTask extends TimerTask {

        @Override
        public void run() {
            service.cleanHistory();
        }
    }

}
