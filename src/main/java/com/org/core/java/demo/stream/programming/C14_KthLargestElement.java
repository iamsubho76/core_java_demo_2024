package com.org.core.java.demo.stream.programming;

import java.util.Arrays;

//Write a program to find the kth largest element in an array using Java 8 streams.
public class C14_KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int kthLargest = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> b - a)
                .limit(k)
                .skip(k - 1)
                .findFirst()
                .orElse(Integer.MIN_VALUE);

        System.out.println("Kth largest element: " + kthLargest);
    }
}
