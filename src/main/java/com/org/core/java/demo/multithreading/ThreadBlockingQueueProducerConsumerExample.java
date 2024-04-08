package com.org.core.java.demo.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadBlockingQueueProducerConsumerExample {
    private static final int QUEUE_CAPACITY = 5;
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {
        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        // Start threads
        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    // Produce data and put it into the queue
                    System.out.println("Producing: " + i);
                    queue.put(i);
                    Thread.sleep(1000); // Simulate some processing time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    // Consume data from the queue
                    int data = queue.take();
                    System.out.println("Consuming: " + data);
                    Thread.sleep(2000); // Simulate some processing time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
