package com.org.core.stream_grouping_sql.demo.v1.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeObject {
    int emp_id;
    String emp_name;
    int emp_age;
    String emp_gender;
    String emp_dep;
    int year_of_joining;
    double emp_salary;

    public EmployeeObject(int emp_id, String name, int age, String gender, String department, int year_of_joining,
                          double salary) {
        this.emp_id = emp_id;
        this.emp_name = name;
        this.emp_age = age;
        this.emp_gender = gender;
        emp_dep = department;
        this.year_of_joining = year_of_joining;
        this.emp_salary = salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_dep() {
        return emp_dep;
    }

    public void setEmp_dep(String emp_dep) {
        this.emp_dep = emp_dep;
    }

    public int getYear_of_joining() {
        return year_of_joining;
    }

    public void setYear_of_joining(int year_of_joining) {
        this.year_of_joining = year_of_joining;
    }

    public double getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }

    public static List<EmployeeObject> getListOfEmployee() {
        List<EmployeeObject> employeeObjectList = new ArrayList<>();

        employeeObjectList.add(new EmployeeObject(111, "Jeya", 30, "Female", "HR", 2011, 25000.0));
        employeeObjectList.add(new EmployeeObject(122, "Polish", 29, "Male", "Sales", 2015, 18500.0));
        employeeObjectList.add(new EmployeeObject(133, "Thomas", 26, "Male", "Administartion", 2012, 18700.0));
        employeeObjectList.add(new EmployeeObject(144, "Gowthami", 29, "Female", "Development", 2014, 33500.0));
        employeeObjectList.add(new EmployeeObject(155, "Nisha", 25, "Female", "HR", 2013, 22000.0));
        employeeObjectList.add(new EmployeeObject(166, "Issac", 40, "Male", "Maintenance", 2016, 12000.0));
        employeeObjectList.add(new EmployeeObject(177, "Sharmila", 30, "Female", "Finance", 2010, 29000.0));
        employeeObjectList.add(new EmployeeObject(188, "Linga", 33, "Male", "Development", 2015, 35000.0));
        employeeObjectList.add(new EmployeeObject(199, "John", 34, "Male", "Sales", 2016, 14500.0));
        employeeObjectList.add(new EmployeeObject(200, "Jeyam", 36, "Male", "Maintenance", 2015, 17000.0));
        employeeObjectList.add(new EmployeeObject(211, "kumar", 37, "Male", "Administartion", 2014, 18700.0));
        employeeObjectList.add(new EmployeeObject(222, "Joshi", 25, "Male", "Development", 2016, 29000.0));
        employeeObjectList.add(new EmployeeObject(233, "Reddy", 29, "Male", "Finance", 2013, 27000.0));
        employeeObjectList.add(new EmployeeObject(244, "Denwer", 28, "Male", "Sales", 2017, 18000.));
        employeeObjectList.add(new EmployeeObject(255, "Alia", 26, "Female", "Administartion", 2018, 13000.0));
        employeeObjectList.add(new EmployeeObject(266, "Sangavi", 36, "Female", "Development", 2015, 29000.0));
        employeeObjectList.add(new EmployeeObject(277, "Anuja", 32, "Female", "Development", 2012, 38000.0));
        return employeeObjectList;
    }
}