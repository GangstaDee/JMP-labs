package com.jmp.thread;

import com.jmp.event.Event;
import com.jmp.event.EventStatus;
import com.jmp.event.EventType;

import java.util.Map;
import java.util.Queue;

/**
 * Created on 31.01.2016.
 */
public class RemovingThread implements Runnable{

    private Map map;
    private Queue<Event> events;

    public RemovingThread(Queue events, Map map) {

        this.map = map;
        this.events = events;
    }

    @Override
    public void run() {

        while(true) {
            synchronized (events) {
                Event e = events.poll();
                if(e != null && EventType.REMOVE.equals(e.getType())) {

                    long start = System.currentTimeMillis();
                    synchronized (map) {
                        map.clear();
                    }

                    long finish = System.currentTimeMillis();
                    e.setProcessingTime(finish - start);
                    e.setStatus(EventStatus.PROCESSED);
                }
            }
        }

    }
}
