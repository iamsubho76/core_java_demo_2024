package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Map;
import java.util.stream.Collectors;

public class C3_AverageAgeGender {
    public static void main(String[] args) {
        Map<String, Double> countOfEmployee = EmployeeObject.getListOfEmployee().stream()
                .collect(Collectors.groupingBy(EmployeeObject::getEmp_gender,
                        Collectors.averagingInt(EmployeeObject::getEmp_age)));
        System.out.println(countOfEmployee);
    }
    //SQL
    /*
    SELECT
        emp_gender,
        AVG(emp_age) AS average_age
    FROM
        employee
    GROUP BY
        emp_gender;
    */
}
