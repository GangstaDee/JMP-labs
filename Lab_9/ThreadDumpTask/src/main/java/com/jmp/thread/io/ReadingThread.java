package com.jmp.thread.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created on 07.02.2016.
 */
public class ReadingThread implements Runnable {

    private int number;
    private ConcurrentLinkedQueue queue;
    private String filepath = null;

    public ReadingThread(int number, String filepath, ConcurrentLinkedQueue queue) {

        this.number = number;
        this.filepath = filepath;
        this.queue = queue;
    }

    @Override
    public void run() {

        Thread.currentThread().setName("Reading thread " + number);

        try {
            while(true) {

                Path path = Paths.get(filepath);
                byte[] content = Files.readAllBytes(path);
                String s = new String(content);
                queue.add(s);

                System.out.println("Reading " + content.length + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //close all
        }
    }
}
