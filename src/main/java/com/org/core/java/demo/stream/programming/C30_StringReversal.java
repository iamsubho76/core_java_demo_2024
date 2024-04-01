package com.org.core.java.demo.stream.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Implement a method to reverse a string using Java 8 streams.
public class C30_StringReversal {
    public static void main(String[] args) {
        String str = "hello";

        String reversed = new StringBuilder(str).reverse().toString();

        List<Character> cv = str.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
        .sorted(Comparator.comparingInt(Character::valueOf).reversed())
                .collect(Collectors.toList());

        System.out.println("Reversed string: " + cv.stream()
                .map(Object::toString)
                .collect(Collectors.joining()));
    }
}
