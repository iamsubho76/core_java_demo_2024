package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.stream.Collectors;

public class C32_ConvertFirstCharToUpperCase {
    public static void main(String[] args) {
        String input = "apple, cherry";
        String resultV1 = Arrays.stream(input.split(", "))
                              .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                              .collect(Collectors.joining(", "));
        
        System.out.println(resultV1);
    }
}
