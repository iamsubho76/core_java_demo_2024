package com.org.core.java.demo.collection.list.listiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorMultithreadingModificationDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Create two threads for modifying the list concurrently
        Thread t1 = new Thread(new ListModificationTask(list, "Thread 1"));
        Thread t2 = new Thread(new ListModificationTask(list, "Thread 2"));

        t1.start();
        t2.start();
    }

    static class ListModificationTask implements Runnable {
        private List<Integer> list;
        private String threadName;

        public ListModificationTask(List<Integer> list, String threadName) {
            this.list = list;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            synchronized (list) { // Ensure thread safety with synchronized block
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    int element = iterator.next();
                    System.out.println(threadName + " processing element: " + element);
                    // Modify the element
                    iterator.set(element * 10);
                }
            }
        }
    }
}
