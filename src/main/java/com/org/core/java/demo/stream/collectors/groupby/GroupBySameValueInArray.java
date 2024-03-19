package com.org.core.java.demo.stream.collectors.groupby;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBySameValueInArray {
    public static void main(String[] args) {
        String[] s = {"java", "abcd", "bcda", "avaj", "subho"};

        // Group strings by their sorted form
        Map<String, String> groupedStrings = Arrays.stream(s)
                .collect(Collectors.groupingBy(GroupBySameValueInArray::sortedString,
                        Collectors.joining(", ")));

        // Print each group
        groupedStrings.forEach((key, value) -> System.out.println(value));
    }

    // Helper method to sort a string alphabetically
    private static String sortedString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}