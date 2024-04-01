package com.org.core.java.demo.stream.programming;

import java.util.Arrays;

//Implement a method to check if a given string is an anagram of another string using Java 8 streams.

public class C11_AnagramChecker {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        boolean isAnagram = Arrays.equals(
                str1.chars().sorted().toArray(),
                str2.chars().sorted().toArray()
        );

        System.out.println("Is anagram? " + isAnagram);
    }
}
