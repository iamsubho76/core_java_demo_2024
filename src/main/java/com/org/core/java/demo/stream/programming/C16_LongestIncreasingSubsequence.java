package com.org.core.java.demo.stream.programming;

import java.util.Arrays;

//Implement a method to find the longest increasing subsequence in a given array of integers using Java 8 streams.
public class C16_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println("Length of longest increasing subsequence: " + maxLength);
    }
}
