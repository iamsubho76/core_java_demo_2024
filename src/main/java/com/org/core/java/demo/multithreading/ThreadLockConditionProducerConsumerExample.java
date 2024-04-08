package com.org.core.java.demo.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A ReentrantLock in Java is a type of lock that allows threads to acquire the lock multiple times.
 * It provides the same basic behavior as synchronized blocks but offers more flexibility and functionality. Threads can attempt to acquire the lock,
 * and if it's not available, they will block until the lock becomes available.
 */
public class ThreadLockConditionProducerConsumerExample {
    private final Queue<Integer> buffer;
    private final int maxSize;

    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    public ThreadLockConditionProducerConsumerExample(int maxSize) {
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;

        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                // Buffer is full, wait for notFull condition
                notFull.await();
            }
            buffer.add(item);
            System.out.println("Produced: " + item);
            // Signal consumers that buffer is not empty
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                // Buffer is empty, wait for notEmpty condition
                notEmpty.await();
            }
            int item = buffer.poll();
            System.out.println("Consumed: " + item);
            // Signal producers that buffer is not full
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadLockConditionProducerConsumerExample buffer = new ThreadLockConditionProducerConsumerExample(5);

        // Create and start producer threads
        for (int i = 0; i < 2; i++) {
            Thread producer = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        buffer.produce(j);
                        Thread.sleep(500); // Simulate production time
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            producer.start();
        }

        // Create and start consumer threads
        for (int i = 0; i < 3; i++) {
            Thread consumer = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        buffer.consume();
                        Thread.sleep(1000); // Simulate consumption time
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            consumer.start();
        }
    }
}
