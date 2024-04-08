package com.org.core.java.demo.multithreading;

public class ThreadInterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running  for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
            }
            System.out.println("Thread interrupted  for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
        });

        System.out.println("Before start for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());
        thread.start();
        System.out.println("After start for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());

        try {
            Thread.sleep(20);
            System.out.println("After sleep for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());

            thread.interrupt(); // Interrupt the thread
            System.out.println("After interrupt for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished for:: " + Thread.currentThread().getName() + " ,for:: " + Thread.currentThread().getThreadGroup().getName());

    }
}
