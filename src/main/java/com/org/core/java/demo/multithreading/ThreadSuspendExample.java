package com.org.core.java.demo.multithreading;

/**
 * The suspend() method in Java is used to suspend the execution of a thread temporarily.
 * However, this method has been deprecated due to its inherent risks,
 * such as potential deadlock and inconsistent thread state.
 */
public class ThreadSuspendExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread started");
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread suspended");
            Thread.currentThread().suspend(); // Suspend the thread
            System.out.println("Thread resumed");
        });

        thread.start();
        try {
            Thread.sleep(1000); // Let the thread start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.resume(); // Resume the suspended thread
    }
}
