package com.org.core.java.demo.stream.programming;

//Write a program to check if a given year is a leap year using Java 8 streams.

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class C13_LeapYearChecker {
    public static void main(String[] args) {
        List<String> years = Arrays.asList("1994", "2000", "2014", "2024");

        IntPredicate p = (year) -> year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

        years.stream().parallel()
                .mapToInt(e -> Integer.parseInt(e))
                .filter(p)
                .forEach(isLeapYear -> System.out.println("Is leap year? " + isLeapYear));
    }
}
