package com.org.core.java.demo.multithreading;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running  for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
        });

        thread.start();
        System.out.println("After start for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
        try {
            thread.join(); // Wait for the thread to finish
            System.out.println("After join for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
    }
}
