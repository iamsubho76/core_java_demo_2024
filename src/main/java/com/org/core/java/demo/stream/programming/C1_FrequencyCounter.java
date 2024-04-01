package com.org.core.java.demo.stream.programming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Write a program to count the occurrences of each character in a string using Java 8 streams.
public class C1_FrequencyCounter {
    public static void main(String[] args) {
        String str = "Hhello";

        Map<Character, Long> singleWordfrequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Character frequency of single work: " + singleWordfrequencyMap);


        System.out.println("===============================================================");
        String s = "string data to count each character";

        LinkedHashMap<String, Long> completeSentenceFrequencyMap = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(strVal -> strVal, LinkedHashMap::new, Collectors.counting()));

        System.out.println("Character frequency of complete sentence: " + completeSentenceFrequencyMap);


        System.out.println("===============================================================");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity()
                                , Collectors.counting()
                        ));
        System.out.println(namesCount);
        System.out.println("Word frequency of complete sentence: " + namesCount);
        System.out.println("Total number of elements:: " + names.stream().count());


        System.out.println("===============================================================");

        String input = "Java Articles are Awesome";

        Character result = input.chars() // Stream of String
                .mapToObj(sV -> Character.toLowerCase(Character.valueOf((char) sV))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println("First repeated character of complete sentence: " + result);

        System.out.println("===============================================================");
        String inputNonRepeated = "Java articles are Awesome";

        Character resultNonRepeated = inputNonRepeated.chars() // Stream of String
                .mapToObj(snr -> Character.toLowerCase(Character.valueOf((char) snr))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println("First non-repeated character of complete sentence: " + resultNonRepeated);
        System.out.println("===============================================================");

    }
}
