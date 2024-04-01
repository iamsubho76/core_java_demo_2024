package com.org.core.java.demo.stream.programming;

import java.util.Arrays;

//Write a program to find the longest common prefix among a list of strings using Java 8 streams.
public class C15_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};

        String longestCommonPrefix = Arrays.stream(strings)
                .reduce((s1, s2) -> {
                    int i = 0;
                    while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                })
                .orElse("");

        System.out.println("Longest common prefix: " + longestCommonPrefix);
    }
}
