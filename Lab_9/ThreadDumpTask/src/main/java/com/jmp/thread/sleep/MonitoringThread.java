package com.jmp.thread.sleep;

/**
 * Created on 07.02.2016.
 */
public class MonitoringThread implements Runnable {

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
