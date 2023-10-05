package com.org.core.java.demo.model;

public class EmployeeGroupBy {

    private int id;
    private String name;
    private long salary;

    private GroupBy groupBy;


    public EmployeeGroupBy(int id, String name, long salary, GroupBy groupBy) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.groupBy = groupBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public GroupBy getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(GroupBy groupBy) {
        this.groupBy = groupBy;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", groupBy=" + groupBy + "]";
    }
}