/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */
package com.org.core.java.demo.collection.map.sort;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

//https://www.java67.com/2017/07/how-to-sort-map-by-values-in-java-8.html

public class Java8SortByValueDemo {
    /**
     * @param args * the command line arguments
     */
    public static void main(String[] args) {
        // Creating a Map with electoric items and prices
        Map<String, Integer> itemToPriceMap = new HashMap<>();
        itemToPriceMap.put("Sony Braiva", 1000);
        itemToPriceMap.put("Apple iPhone 6S", 1200);
        itemToPriceMap.put("HP Laptop", 700);
        itemToPriceMap.put("Acer HD Monitor", 139);
        itemToPriceMap.put("Samsung Galaxy", 800);
        System.out.println("unsorted Map: " + itemToPriceMap);


        // sorting Map by values in ascending order, price here
        itemToPriceMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


        // now, let's collect the sorted entries in Map
        Map<String, Integer> sortedByPrice = itemToPriceMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println("Map incorrectly sorted by value in ascending order: " + sortedByPrice);


        // the Map returned by the previous statement was not sorted
        // because ordering was lost while collecting result in Map
        // you need to use the LinkedHashMap to preserve the order
        Map<String, Integer> sortedByValue = itemToPriceMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Map sorted by value in increasing order: " + sortedByValue);


        // sorting a Map by values in descending order
        // just reverse the comparator sorting by using reversed() method
        Map<String, Integer> sortedByValueDesc = itemToPriceMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Map sorted by value in descending order: " + sortedByValueDesc);
    }
}