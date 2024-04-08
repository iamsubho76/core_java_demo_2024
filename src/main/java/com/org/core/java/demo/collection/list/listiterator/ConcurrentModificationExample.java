package com.org.core.java.demo.collection.list.listiterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

/**
 * Yes, ListIterator can throw a ConcurrentModificationException if the underlying list is
 * structurally modified (i.e., elements are added, removed, or modified) during iteration,
 * except through the iterator's own methods such as remove(), set(), and add().
 */
public class ConcurrentModificationExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element == 2) {
                // This will throw ConcurrentModificationException
                //list.remove(Integer.valueOf(3));
                // But below one won't throw
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
