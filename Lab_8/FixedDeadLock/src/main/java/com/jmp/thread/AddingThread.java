package com.jmp.thread;

import com.jmp.event.Event;
import com.jmp.event.EventStatus;
import com.jmp.event.EventType;

import java.util.Map;
import java.util.Queue;
import java.util.Random;

/**
 * Created on 31.01.2016.
 */
public class AddingThread implements Runnable {

    private Map map;
    private Queue<Event> events;

    public AddingThread(Queue events, Map map) {

        this.map = map;
        this.events = events;
    }

    @Override
    public void run() {

        while(true) {
            Event e = events.poll();
            if(e != null && EventType.ADD.equals(e.getType())) {
                long start = System.currentTimeMillis();
                map.put(new Random().nextInt(), new Object());
                long finish = System.currentTimeMillis();
                e.setProcessingTime(finish - start);
                e.setStatus(EventStatus.PROCESSED);
            }
        }

    }
}
