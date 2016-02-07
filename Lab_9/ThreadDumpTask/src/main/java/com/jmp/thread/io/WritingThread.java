package com.jmp.thread.io;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created on 07.02.2016.
 */
public class WritingThread implements Runnable {

    private int number;
    private ConcurrentLinkedQueue<String> queue;
    private String filepath;

    public WritingThread(int number, String filepath, ConcurrentLinkedQueue queue) {

        this.number = number;
        this.filepath = filepath;
        this.queue = queue;
    }

    @Override
    public void run() {

        Thread.currentThread().setName("Writing thread " + number);

        try {
            while(true) {
                String s = queue.poll();
                if(s != null) {
                    byte content[] = s.getBytes();
                    Path file = Paths.get(filepath);
                    Files.write(file, content);
                    System.out.println("Writing " + content.length + " bytes");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //close all
        }

    }
}
