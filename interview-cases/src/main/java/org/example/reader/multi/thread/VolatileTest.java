package org.example.reader.multi.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    //    private static volatile int a = 0;
    private static volatile AtomicInteger a = new AtomicInteger(0);

    private static void increse() {
//        a++;
        //volatile不保证原子性
        a.getAndIncrement();
    }


    public static void main(String[] args) {
        int threadCount = 10;
        System.out.println(Thread.activeCount() + " active");
        Thread.currentThread().getThreadGroup().list();
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increse();
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(a);
    }

}
