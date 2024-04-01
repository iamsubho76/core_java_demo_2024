package com.org.core.java.demo.stream.programming;

import java.util.HashMap;
import java.util.Map;

//Write a program to find the longest subarray with equal number of 0s and 1s using Java 8 streams.

public class C19_LongestSubarrayWithEqualZeroOne {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 1, 0};

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        System.out.println("Longest subarray length: " + maxLength);
    }
}
