package com.org.core.java.demo.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMultithreadingDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Create two threads for iterating the list concurrently
        Thread t1 = new Thread(new IteratorTask(list.iterator(), "Thread 1"));
        Thread t2 = new Thread(new IteratorTask(list.iterator(), "Thread 2"));

        t1.start();
        t2.start();
    }

    static class IteratorTask implements Runnable {
        private Iterator<Integer> iterator;
        private String threadName;

        public IteratorTask(Iterator<Integer> iterator, String threadName) {
            this.iterator = iterator;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            synchronized (iterator) { // Ensure thread safety with synchronized block
                while (iterator.hasNext()) {
                    int element = iterator.next();
                    System.out.println(threadName + " processing element: " + element);
                    try {
                        Thread.sleep(100); // Simulate some processing
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
