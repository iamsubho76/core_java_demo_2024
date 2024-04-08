package com.org.core.java.demo.multithreading;

import java.util.concurrent.Semaphore;


/**
 * In this example:
 *
 * - We have a `Semaphore` with an initial count of `NUM_RESOURCES`, representing the number of resources available for concurrent access.
 * - Multiple worker threads are created, each trying to acquire a resource from the semaphore.
 * - Each worker thread acquires a resource using `semaphore.acquire()` before performing its work.
 * - Once the work is done, the worker thread releases the resource using `semaphore.release()`.
 * - If there are no available resources when a worker thread tries to acquire one, it will block until a resource becomes available.
 *
 * This example demonstrates how `Semaphore` can be used to control access to a limited set of resources by multiple threads. The semaphore ensures that the number of concurrent accesses to the resources does not exceed the specified limit. Adjusting the value of `NUM_RESOURCES` allows you to control the level of concurrency in the system.
 */
public class ThreadSemaphoreExample {
    private static final int NUM_THREADS = 10;
    private static final int NUM_RESOURCES = 3;
    private static final Semaphore semaphore = new Semaphore(NUM_RESOURCES);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new Worker("Thread-" + i));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                // Acquire a resource from the semaphore
                System.out.println(name + " is trying to acquire a resource");
                semaphore.acquire();
                System.out.println(name + " has acquired a resource");

                // Simulate some work with the resource
                Thread.sleep(1000);

                // Release the resource back to the semaphore
                System.out.println(name + " is releasing the resource");
                semaphore.release();
                System.out.println(name + " has released the resource");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
