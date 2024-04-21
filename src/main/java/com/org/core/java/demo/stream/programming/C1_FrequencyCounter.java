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

        System.out.println("Character frequency of single word: " + singleWordfrequencyMap);


        System.out.println("===============================================================");
        String s = "string data to count each character";

        LinkedHashMap<String, Long> completeSentenceFrequencyMap = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(strVal -> strVal, LinkedHashMap::new, Collectors.counting()));
        System.out.println("Character frequency of complete sentence v1: " + completeSentenceFrequencyMap);

        // below one is better approach
        LinkedHashMap<Character, Long> collect = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        ;

        System.out.println("Character frequency of complete sentence v2: " + collect);


        System.out.println("===============================================================");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity()
                                , Collectors.counting()
                        ));
        System.out.println("Word frequency of complete list: " + namesCount);
        System.out.println("Total number of elements:: " + names.stream().count());
        System.out.println("===============================================================");
        char[] c = {'A', 'B', 'C', 'A', 'C', 'D', 'A', 'D'};

        // Calculate frequency of each character
        Map<Character, Long> frequencyMap = new String(c).chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        // Sort by value (frequency) in ascending order and print
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println("Character: " + entry.getKey() + ", Frequency: " + entry.getValue()));
        System.out.println("===============================================================");

        String getRepeatedWordCount = "aa bb gg hh yy uu aa bb";

        // Collect words into a LinkedHashMap with counts
        LinkedHashMap<String, Long> wordCounts = Arrays.stream(getRepeatedWordCount.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Skip the first n - 2 entries and limit to the last two entries
        Map<String, Long> lastTwoRepeatedWords = wordCounts.entrySet().stream()
                .skip(Math.max(0, wordCounts.size() - 2))
                .limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Last two repeated words : " + lastTwoRepeatedWords);

        // Skip the first n - 2 entries and limit to the last two entries
        Map<String, Long> firstTwoRepeatedWords = wordCounts.entrySet().stream()
                .limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("First two repeated words : " + firstTwoRepeatedWords);

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
