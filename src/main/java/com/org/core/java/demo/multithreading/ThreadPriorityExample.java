package com.org.core.java.demo.multithreading;

/**
 * In Java, threads can have different priorities ranging from MIN_PRIORITY (1) to MAX_PRIORITY (10),
 * with NORM_PRIORITY (5) being the default priority. The thread scheduler uses these priorities
 * to determine the order in which threads are scheduled for execution. Threads with higher
 * priorities are scheduled to run more frequently than threads with lower priorities.
 */
public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 executing iteration " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 executing iteration " + i);
            }
        });

        // Set the priority of thread1 to MIN_PRIORITY (1)
        thread1.setPriority(Thread.MIN_PRIORITY);
        
        // Set the priority of thread2 to MAX_PRIORITY (10)
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
