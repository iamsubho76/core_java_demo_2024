package com.org.core.java.demo.stream.programming;

import java.util.Arrays;

//Implement a method to find the missing number in a given array of consecutive numbers using Java 8 streams.
public class C23_MissingNumberFinder {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 7};

        int expectedSum = (nums.length + 1) * (nums.length + 2) / 2;
        int actualSum = Arrays.stream(nums).sum();

        int missingNumber = expectedSum - actualSum;

        System.out.println("Missing number: " + missingNumber);
    }
}
