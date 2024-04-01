package com.org.core.java.demo.stream.programming;

//Implement a method to find the longest palindromic substring in a given string using Java 8 streams.

public class C18_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";

        String longestPalindrome = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (isPalindrome(substring) && substring.length() > longestPalindrome.length()) {
                    longestPalindrome = substring;
                }
            }
        }

        System.out.println("Longest palindromic substring: " + longestPalindrome);
    }

    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
