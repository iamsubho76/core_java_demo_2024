package com.org.core.java.demo.stream.programming;

import java.util.stream.Stream;

public class C6_ConcatenateStream {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);

        // Concatenate two streams
        Stream<Integer> concatenatedStream = Stream.concat(stream1, stream2);

        // Print the concatenated stream
        concatenatedStream.forEach(System.out::println);
    }
}
