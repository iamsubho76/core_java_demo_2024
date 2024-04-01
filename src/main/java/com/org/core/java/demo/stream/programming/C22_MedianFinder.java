package com.org.core.java.demo.stream.programming;

import java.util.Arrays;

//Implement a method to find the median of a list of integers using Java 8 streams.
public class C22_MedianFinder {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 6, 1, 3, 4};

        double median = Arrays.stream(numbers)
                .sorted()
                .skip(numbers.length / 2 - 1 + (numbers.length % 2 == 0 ? 0 : 1))
                .limit(2 - (numbers.length % 2))
                .average()
                .orElse(Double.NaN);

        System.out.println("Median: " + median);
    }
}
