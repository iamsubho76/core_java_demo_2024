package com.org.core.java.demo.multithreading;

public class ThreadRunExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
    }

    public static void main(String[] args) {
        ThreadRunExample thread = new ThreadRunExample();
        thread.start();
    }
}
