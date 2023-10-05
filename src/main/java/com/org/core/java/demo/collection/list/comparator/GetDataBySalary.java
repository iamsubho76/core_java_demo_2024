package com.org.core.java.demo.collection.list.comparator;

import com.org.core.java.demo.model.Recruitment;

import java.util.Comparator;

public class GetDataBySalary implements Comparator<Recruitment> {
	@Override
	public int compare(Recruitment recruitment1, Recruitment recruitment2) {
		return (int) (recruitment1.getSalary() - recruitment2.getSalary());
	}

}