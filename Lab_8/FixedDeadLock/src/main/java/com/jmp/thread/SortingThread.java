package com.jmp.thread;

import com.jmp.event.Event;
import com.jmp.event.EventStatus;
import com.jmp.event.EventType;

import java.util.Map;
import java.util.Queue;

/**
 * Created on 31.01.2016.
 */
public class SortingThread implements Runnable {

    private Map map;
    private Queue<Event> events;

    public SortingThread(Queue events, Map map) {

        this.map = map;
        this.events = events;
    }


    @Override
    public void run() {

        while(true) {
            Event e = events.poll();
            if(e != null && EventType.SORT.equals(e.getType())) {
                long start = System.currentTimeMillis();
                if(!map.isEmpty()) {
                    map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue());
                }
                long finish = System.currentTimeMillis();
                e.setProcessingTime(finish - start);
                e.setStatus(EventStatus.PROCESSED);
            }
        }
    }
}
