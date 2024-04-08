package com.org.core.java.demo.multithreading;

public class ThreadSleepExample {
    public static void main(String[] args) {
        System.out.println("Thread is sleeping for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread woke up");
    }
}
