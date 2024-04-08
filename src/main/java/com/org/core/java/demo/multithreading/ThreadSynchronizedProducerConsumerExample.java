package com.org.core.java.demo.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadSynchronizedProducerConsumerExample {
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 5;

        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                synchronized (buffer) {
                    // If buffer is full, wait for consumer to consume
                    while (buffer.size() == maxSize) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Produce a value and add it to the buffer
                    System.out.println("Producer produced: " + value);
                    buffer.add(value++);
                    // Notify consumer that a value is available
                    buffer.notify();
                    try {
                        Thread.sleep(1000); // Simulate some processing time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    // If buffer is empty, wait for producer to produce
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Consume a value from the buffer
                    int value = buffer.poll();
                    System.out.println("Consumer consumed: " + value);
                    // Notify producer that space is available in the buffer
                    buffer.notify();
                    try {
                        Thread.sleep(1000); // Simulate some processing time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
