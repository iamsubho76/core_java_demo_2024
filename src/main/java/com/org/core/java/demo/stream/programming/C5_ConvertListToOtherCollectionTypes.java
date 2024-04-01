package com.org.core.java.demo.stream.programming;

import com.org.core.java.demo.model.Notes;

import java.util.*;
import java.util.stream.Collectors;

public class C5_ConvertListToOtherCollectionTypes {
    public static void main(String[] args) {

        // Consider the Note object unique if it's tagName is unique
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(6, "note4", 66));


        Map<String, Long> notesRecords = noteLst.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getTagId)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                .collect(Collectors.toMap
                        (Notes::getTagName, Notes::getTagId,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        // consider old value 44 for dupilcate key
        // it keeps order
        System.out.println("Notes map by tagName key: " + notesRecords);
        System.out.println("========================================================================================================================");


        List<Integer> list = Arrays.asList(90, 8, 79, 6, 88, 10, 90);

        // Convert list to LinkedHashMap
        LinkedHashMap<Integer, Integer> linkedHashMap = list.stream()
                .collect(Collectors.toMap(
                        // Key mapper: identity function (same as the element itself)
                        //key -> key,
                        key -> Math.abs(UUID.randomUUID().hashCode()),
                        // Value mapper: identity function (same as the element itself)
                        value -> value,
                        // Merge function: handle collisions (use existing value)
                        (existingValue, newValue) -> existingValue,
                        // Map supplier: LinkedHashMap
                        LinkedHashMap::new
                ));

        // Print the LinkedHashMap
        System.out.println("Integer list to map: " +linkedHashMap);
        System.out.println("========================================================================================================================");

        List<Integer> listForSet = Arrays.asList(1, 2, 3, 4, 5, 5); // Example list with duplicates

        // Convert list to set
        Set<Integer> setObj = listForSet.stream()
                .collect(Collectors.toSet());

        // Print the set
        System.out.println("Set: " + setObj);

        System.out.println("========================================================================================================================");
        List<Integer> listForTreeSet = Arrays.asList(5, 2, 7, 3, 1, 5); // Example list

        // Convert list to TreeSet
        TreeSet<Integer> treeSetObj = listForTreeSet.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        // Print the TreeSet
        System.out.println("TreeSet: " + treeSetObj);
    }
}
