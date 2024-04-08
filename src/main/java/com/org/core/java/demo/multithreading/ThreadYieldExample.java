package com.org.core.java.demo.multithreading;

/**
 * The yield() method in Java is used to temporarily pause the execution of the currently executing
 * thread and give other threads of the same priority a chance to execute.
 * It is a hint to the scheduler that the current thread is willing to yield its current use of
 * the processor.
 * However, it's important to note that the scheduler may choose to ignore this hint.
 */
public class ThreadYieldExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 executing iteration " + i);
                // Yield control to other threads after each iteration
                Thread.yield();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 executing iteration " + i);
                // Yield control to other threads after each iteration
                Thread.yield();
            }
        });

        thread1.start();
        thread2.start();
    }
}
