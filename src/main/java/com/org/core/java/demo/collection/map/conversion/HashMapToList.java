package com.org.core.java.demo.collection.map.conversion;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Java Program to Convert HashMap into ArrayList in Java
 */
public class HashMapToList {
    public static void main(String... args) {
        HashMap<String, Integer> schoolAgeCriteria = new HashMap<String, Integer>();
        // preparing HashMap with keys and values
        schoolAgeCriteria.put("NursuryClass age criteria", 3);
        schoolAgeCriteria.put("KinderGarden1 age criteria ", 4);
        schoolAgeCriteria.put("KinderGarden2 age criteria ", 5);
        schoolAgeCriteria.put("PrimarySchool age criteria", 6);
        System.out.println("Size of schoolAgeCriteria Map: " + schoolAgeCriteria.size());

        // 1st Example : Converting HashMap keys into ArrayList
        Set<String> keySet = schoolAgeCriteria.keySet();
        List<String> schoolKeyList = new ArrayList<>(keySet);
        System.out.println("Size of Key list from Map: " + schoolKeyList.size());


        // print list element
        System.out.println("Printing HashMap keys from converted list : ");
        for (String key : schoolKeyList) {
            System.out.println(key);
        }


        // 2nd Example : Converting HashMap Values into ArrayList
        Collection<Integer> values = schoolAgeCriteria.values();
        List<Integer> schoolValueList = new ArrayList<>(values);
        System.out.println("Size of Value list from Map: " + schoolValueList.size());

        // print values from list
        System.out.println("Printing HashMap values from converted list :");
        for (Integer value : schoolValueList) {
            System.out.println(value);
        }

        // 3rd Example : Converting HashMap into ArrayList using Entry Set
        Set<Entry<String, Integer>> set = schoolAgeCriteria.entrySet();
        List<Entry<String, Integer>> schoolAgeCriteriaList = new ArrayList<>(set);
        Iterator<Entry<String, Integer>> it = schoolAgeCriteriaList.iterator();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            System.out.println("Entry from converted list : " + entry);
        }

        // 4th Example using Java8
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        List<String> result = createListFromMapEntries(map);
        result.forEach(System.out :: println);
    }

    private static <K, V>  List<V> createListFromMapEntries (Map<K, V> map){
        return map.values().stream().collect(Collectors.toList());
    }
}