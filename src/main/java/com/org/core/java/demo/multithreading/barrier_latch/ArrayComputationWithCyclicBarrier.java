package com.org.core.java.demo.multithreading.barrier_latch;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class ArrayComputationWithCyclicBarrier {
    // Define the size of the array
    static int arraySize = 1000000; // 1 million elements
    // Generate a random array of positive integers
    static int[] array = generateRandomIntArray(arraySize);
    private static final int NUM_THREADS = 3; // Number of threads to process the array
    //private static final int[] array = {10, 40, 70, 90, 80, 100};
    private static final int ARRAY_SIZE = array.length;

    public static void main(String[] args) throws InterruptedException {
//        long startTimeMillis = System.currentTimeMillis();

        // Create a CyclicBarrier with the action to compute sum
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, ArrayComputationWithCyclicBarrier::aggregate);

        // Create and start threads
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new Worker(barrier, i));
            thread.start();
        }
//        long endTimeMillis = System.currentTimeMillis();
//
//        // Print the current time in milliseconds
//        System.out.println("Time elapsed:: " + (endTimeMillis - startTimeMillis));
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final int id;

        public Worker(CyclicBarrier barrier, int id) {
            this.barrier = barrier;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Process the array elements assigned to this thread
                for (int i = id; i < ARRAY_SIZE; i += NUM_THREADS) {
                    // Simulate computation
                    compute(i);
                }
                // Wait for all threads to finish processing
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    private static void compute(int i) {
        array[i] *= 10;
        System.out.println(Thread.currentThread().getName() + " computed result for: " + i);
    }

    // Method to aggregate the sum of updated elements
    private static void aggregate() {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        System.out.println("Sum of updated elements: " + sum);
    }

    // Method to generate a random array of positive integers
    private static int[] generateRandomIntArray(int size) {
        Random random = new Random();
        return random.ints(size, 1, Integer.MAX_VALUE).toArray();
    }
}
