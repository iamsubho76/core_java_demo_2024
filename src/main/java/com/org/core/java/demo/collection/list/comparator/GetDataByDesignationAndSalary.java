package com.org.core.java.demo.collection.list.comparator;

import com.org.core.java.demo.model.Recruitment;

import java.util.Comparator;

public class GetDataByDesignationAndSalary implements Comparator<Recruitment> {

	@Override
	public int compare(Recruitment recruitment1, Recruitment recruitment2) {
		int designationComparision = recruitment1.getDesignation().compareTo(recruitment2.getDesignation());
		int salaryComparision = (int) (recruitment1.getSalary() - recruitment2.getSalary());
		return (salaryComparision == 0) ? designationComparision
				: salaryComparision;
	}
	
}