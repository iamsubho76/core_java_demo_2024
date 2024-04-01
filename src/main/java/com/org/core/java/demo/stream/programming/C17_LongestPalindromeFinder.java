package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//Write a program to find the longest palindrome in a given list of strings using Java 8 streams.
public class C17_LongestPalindromeFinder {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aba", "racecar", "hello", "civic");

        Predicate<String> p = str -> str.equals(new StringBuilder(str).reverse().toString());
        String longestPalindrome = strings.stream()
                .filter(p)
                .max((s1, s2) -> s1.length() - s2.length())
                .orElse("Not found");

        System.out.println("Longest palindrome: " + longestPalindrome);
    }
}
