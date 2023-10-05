package com.org.core.java.demo.model;

public class GroupBy {

    private String designation;
    private String gender;

    public GroupBy(String designation, String gender) {
        super();
        this.designation = designation;
        this.gender = gender;
    }

    @Override
    public int hashCode() {

        return this.designation.length() + this.gender.length();
    }

    @Override
    public boolean equals(Object obj) {

        GroupBy other = (GroupBy) obj;

		return other.getDesignation().equals(this.designation) && other.getGender().equals(this.gender);
	}

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "GroupBy [designation=" + designation + ", gender=" + gender + "]";
    }
}