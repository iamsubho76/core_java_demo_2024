package com.org.core.java.demo.clone.deep;

import java.util.Arrays;

// Code explaining deep copy
public class Ex {

    private final int[] data;

    // altered to make a deep copy of values
    public Ex(int[] values) {
        data = new int[values.length];
		System.arraycopy(values, 0, data, 0, data.length);
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
