package com.org.core.java.demo.stream.programming;

import java.util.stream.Stream;

//Write a program to calculate the Fibonacci sequence up to a given number using Java 8 streams.
// This is HARD problem
public class C10_FibonacciSequence {
    public static void main(String[] args) {
        int limit = 10;

        // This line creates a stream of Fibonacci numbers using the Stream.iterate method.
        // It starts with an initial value of [0, 1] (representing the first two Fibonacci numbers)
        // and applies a function to generate subsequent Fibonacci numbers.
        // The function fib -> new int[]{fib[1], fib[0] + fib[1]} takes an array representing
        // the last two Fibonacci numbers and produces a new array
        // containing the next Fibonacci number and the sum of the last two Fibonacci numbers.
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(limit)
                .mapToInt(fib -> fib[0])
                .forEach(System.out::println);
    }
}
