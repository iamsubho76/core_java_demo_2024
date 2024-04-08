package com.org.core.java.demo.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMutexExample {
    private static final int NUM_THREADS = 10;
    private static final int NUM_INCREMENTS = 1000;
    private static int counter = 0;
    private static final Lock mutex = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Incrementer("Thread-" + i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final counter value: " + counter);
    }

    static class Incrementer implements Runnable {
        private final String name;

        public Incrementer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_INCREMENTS; i++) {
                mutex.lock();
                try {
                    counter++;
                } finally {
                    mutex.unlock();
                }
            }
            System.out.println(name + " finished incrementing.");
        }
    }
}
