package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

public class C5_EmpJoinedAfterCertainDate {
    public static void main(String[] args) {
        EmployeeObject.getListOfEmployee().stream().filter(e -> e.getYear_of_joining() > 2015).map(EmployeeObject::getEmp_name)
                .forEach(System.out::println);
    }
    //SQL
    /*
    SELECT emp_name
    FROM employee
    WHERE year_of_joining > 2014;
    */
}
