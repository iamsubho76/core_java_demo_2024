package com.org.core.java.demo.collection.map.sort;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*; /* * Java Program to sort a Map by keys in Java 8 * */

public class Java8SortByKeyDemo {
    public static void main(String[] args) throws Exception {
        // a Map with string keys and integer values
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println("map before sorting: " + budget);

        // let's sort this map by keys first
        Map<String, Integer> sorted = budget.entrySet().stream().sorted(comparingByKey()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("map after sorting by keys: " + sorted);

        // above code can be cleaned a bit by using method reference
        sorted = budget.entrySet().stream().sorted(comparingByKey()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("map after sorting by keys in cleaned way: " + sorted);

        // now let's sort the map in decreasing order of keys
        sorted = budget.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("map after sorting by keys in descending order in cleaned way: " + sorted);
    }
}