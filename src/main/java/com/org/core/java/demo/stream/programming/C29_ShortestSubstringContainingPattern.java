package com.org.core.java.demo.stream.programming;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//Implement a method to find the shortest substring containing all characters of a
// given pattern in a string using Java 8 streams.

//This is HARD problem
public class C29_ShortestSubstringContainingPattern {
    public static void main(String[] args) {
        String str = "XAYAXBZ";
        String pattern = "XYZ";

        Set<Character> patternSet = pattern.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());

        Set<Character> windowSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        String shortestSubstring = "";

        while (right < str.length()) {
            char current = str.charAt(right);
            windowSet.add(current);

            while (windowSet.containsAll(patternSet)) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    shortestSubstring = str.substring(left, right + 1);
                }
                char leftChar = str.charAt(left);
                windowSet.remove(leftChar);
                left++;
            }
            right++;
        }

        System.out.println("Shortest substring containing pattern: " + shortestSubstring);
    }
}
