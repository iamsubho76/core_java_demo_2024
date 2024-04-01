package com.org.core.java.demo.stream.programming;

import java.util.stream.Collectors;

//Write a program to remove duplicate characters from a string using Java 8 streams.

public class C28_RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String str = "hello";

        String result = str.chars()
                .distinct()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());

        System.out.println("String after removing duplicates: " + result);
    }
}
