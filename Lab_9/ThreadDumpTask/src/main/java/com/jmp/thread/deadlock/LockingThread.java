package com.jmp.thread.deadlock;


/**
 * Created on 07.02.2016.
 */
public class LockingThread implements Runnable {

    private int number;
    private Object monitor1;
    private Object monitor2;

    public LockingThread(int number, Object monitor1, Object monitor2) {

        this.number = number;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
    }

    @Override
    public void run() {

        Thread.currentThread().setName("Thread " + number);

        while(true) {
            synchronized (monitor1) {
                System.out.println("Thread " + number + " has locked " + monitor1.toString());
                monitor1.toString();

                synchronized (monitor2) {
                    System.out.println("Thread " + number + " has locked " + monitor1.toString());
                    monitor2.toString();
                }
            }
        }
    }
}
