package com.org.core.java.demo.stream.programming;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class C3_FindEmptyListOrPrintUsingOptional {
    public static void main(String[] args) {
        List<String> noteLst = null;//Collections.singletonList("tomorrow is holiday");

        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(note -> note.toUpperCase()) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names
    }
}
