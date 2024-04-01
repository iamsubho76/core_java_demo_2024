package com.org.core.java.demo.stream.programming;

//Write a program to check if a string is a palindrome using Java 8 streams.
public class C25_PalindromeChecker {
    public static void main(String[] args) {
        String str = "radar";

        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());

        System.out.println("Is palindrome? " + isPalindrome);
    }
}
