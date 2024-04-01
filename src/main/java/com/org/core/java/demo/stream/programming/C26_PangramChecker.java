package com.org.core.java.demo.stream.programming;

//Write a program to check if a given string is a pangram using Java 8 streams.

public class C26_PangramChecker {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";

        boolean isPangram = str.toLowerCase().chars()
                .filter(Character::isAlphabetic)
                .distinct()
                .count() == 26;

        System.out.println("Is pangram? " + isPangram);
    }
}
