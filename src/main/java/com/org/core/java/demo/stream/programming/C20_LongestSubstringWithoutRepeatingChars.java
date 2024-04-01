package com.org.core.java.demo.stream.programming;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

//Write a program to find the longest substring without repeating
// characters in a given string using Java 8 streams.
public class C20_LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String str = "abcabcbb";

        int maxLength = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .size();

        System.out.println("Length of longest substring without repeating characters: " + maxLength);
    }
}
