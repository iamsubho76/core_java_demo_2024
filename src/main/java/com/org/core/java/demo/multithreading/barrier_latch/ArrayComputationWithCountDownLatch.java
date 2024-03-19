package com.org.core.java.demo.multithreading.barrier_latch;

import java.util.concurrent.CountDownLatch;

public class ArrayComputationWithCountDownLatch {
    private static final int[] array = {1, 45, 78, 90, 87, 100};
    private static final int ARRAY_SIZE = array.length;
    private static final int NUM_THREADS = ARRAY_SIZE; // Number of threads equal to the size of the array
    private static volatile int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(NUM_THREADS);

        // Create and start threads
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new Worker(i, latch));
            thread.start();
        }

        // Wait for all threads to finish processing
        latch.await();

        // Print the sum of updated elements
        System.out.println("Sum of updated elements: " + sum);
    }

    static class Worker implements Runnable {
        private final int index;
        private final CountDownLatch latch;

        public Worker(int index, CountDownLatch latch) {
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {
            // Multiply each element by 10
            array[index] *= 10;

            // Aggregate the result
            synchronized (ArrayComputationWithCountDownLatch.class) {
                sum += array[index];
            }

            // Count down the latch to indicate completion
            latch.countDown();
        }
    }
}
