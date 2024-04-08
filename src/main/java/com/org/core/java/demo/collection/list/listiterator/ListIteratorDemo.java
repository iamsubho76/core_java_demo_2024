package com.org.core.java.demo.collection.list.listiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator in Java provides a way to traverse and modify elements of a list bidirectionally.
 * It's an iterator for lists that allows you to move both forward and backward through the list,
 * as well as modify the list during iteration.
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        // Create a list
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Iterate forward using ListIterator
        System.out.println("Forward traversal:");
        ListIterator<String> forwardIterator = list.listIterator();
        while (forwardIterator.hasNext()) {
            System.out.println(forwardIterator.next());
        }

        // Iterate backward using ListIterator
        System.out.println("\nBackward traversal:");
        ListIterator<String> backwardIterator = list.listIterator(list.size());
        while (backwardIterator.hasPrevious()) {
            System.out.println(backwardIterator.previous());
        }

        // Modify list elements using ListIterator
        System.out.println("\nModify list elements:");
        ListIterator<String> modifyIterator = list.listIterator();
        while (modifyIterator.hasNext()) {
            String element = modifyIterator.next();
            if (element.equals("Banana")) {
                modifyIterator.set("Grapes");
            }
        }

        // Print modified list
        System.out.println(list);
    }
}
