package com.jmp.main;

import com.jmp.thread.deadlock.LockingThread;
import com.jmp.thread.io.ReadingThread;
import com.jmp.thread.io.WritingThread;
import com.jmp.thread.sleep.MonitoringThread;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 07.02.2016.
 */
public class Runner {

    public static void main(String[] args) {

        //just random types
        final String o1 = "string";
        final ArrayList o2 = new ArrayList();
        final Boolean o3 = Boolean.TRUE;
        final Integer o4 = Integer.valueOf(5);

        ExecutorService service = Executors.newFixedThreadPool(20);
        service.submit(new LockingThread(1,o1,o2));
        service.submit(new LockingThread(2,o2,o3));
        service.submit(new LockingThread(3,o3,o4));
        service.submit(new LockingThread(4,o4,o1));

        for(int i = 0; i < 8; i++)
            service.submit(new MonitoringThread());

        ConcurrentLinkedQueue<String> sharedQueue = new ConcurrentLinkedQueue<>();
        for(int i = 0; i < 4; i++)
            service.submit(new ReadingThread(i+1, "###########", sharedQueue));

        for(int i = 0; i < 4; i++)
            service.submit(new WritingThread(i+1, "###########", sharedQueue));
    }
}
