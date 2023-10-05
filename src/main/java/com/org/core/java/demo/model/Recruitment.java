package com.org.core.java.demo.model;

public class Recruitment {
    String companyName;
    String designation;
    String employeeName;
    double salary;
    boolean status;

    public Recruitment(String companyName, String employeeName, String designation, double salary, boolean status) {
        super();
        this.companyName = companyName;
        this.employeeName = employeeName;
        this.designation = designation;
        this.salary = salary;
        this.status = status;
    }

    public Recruitment() {
        // via setter methods, rest fields are done
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Method of Recruitment class
    // To print Recruitment details in main()
    public String toString() {

        // Returning attributes of Recruitment
        return this.companyName + " " + this.employeeName + " "
                + this.designation + " " + this.salary + " " + this.status;
    }
}

