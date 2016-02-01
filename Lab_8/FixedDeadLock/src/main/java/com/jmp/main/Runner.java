package com.jmp.main;

import com.jmp.event.Event;
import com.jmp.thread.AddingThread;
import com.jmp.thread.EventGenerator;
import com.jmp.thread.RemovingThread;
import com.jmp.thread.SortingThread;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created on 31.01.2016.
 */
public class Runner {

    public static void main(String[] args) {

        Queue<Event> events = new ConcurrentLinkedQueue<>();
        Map<Integer, Object> map = new ConcurrentHashMap<>();

        new Thread(new EventGenerator(events, map), "EventGenerator").start();
        new Thread(new AddingThread(events, map), "thread.AddingThread").start();
        new Thread(new RemovingThread(events, map), "RemovingThread").start();
        new Thread(new SortingThread(events, map), "SortingThread").start();
    }
}
