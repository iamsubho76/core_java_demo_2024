package com.org.core.java.demo.multithreading;

import java.util.concurrent.atomic.AtomicBoolean;

public class BusySpinExample {
    private static AtomicBoolean condition = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            // Busy spinning loop
            while (!condition.get()) {
                // Perform some trivial work or yield the processor
                // (To avoid consuming CPU resources excessively)
                Thread.yield();
            }
            System.out.println("Condition is true, exiting thread 1");
        });

        Thread thread2 = new Thread(() -> {
            // Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Set the condition to true
            condition.set(true);
            System.out.println("Condition set to true by thread 2");
        });

        thread1.start();
        thread2.start();
    }
}
