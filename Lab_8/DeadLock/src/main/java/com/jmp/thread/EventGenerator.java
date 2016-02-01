package com.jmp.thread;

import com.jmp.event.Event;
import com.jmp.event.EventStatus;
import com.jmp.event.EventType;

import java.util.*;

/**
 * Created on 31.01.2016.
 */
public class EventGenerator implements Runnable {

    private Queue<Event> events;
    private Map map;

    public EventGenerator(Queue<Event> events, Map map) {
        this.events = events;
        this.map = map;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (map) {
                if (map.size() < 100) {

                    synchronized (events) {
                        List<EventType> values = Arrays.asList(EventType.values());
                        events.add(new Event(new Random().nextInt(),
                                values.get(new Random().nextInt(values.size())), EventStatus.NEW, 0));
                    }
                }
            }
        }
    }
}
