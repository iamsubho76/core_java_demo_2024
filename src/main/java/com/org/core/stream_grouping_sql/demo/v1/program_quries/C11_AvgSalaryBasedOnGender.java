package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Map;
import java.util.stream.Collectors;

public class C11_AvgSalaryBasedOnGender {
    public static void main(String[] args) {
        Map<String, Double> avgSalaryByGender =
                EmployeeObject.getListOfEmployee().stream()
                        .collect(Collectors.groupingBy(EmployeeObject::getEmp_gender, Collectors.averagingDouble(EmployeeObject::getEmp_salary)));
        System.out.println(avgSalaryByGender);
    }
}

    // SQL
    /*
    SELECT
    emp_gender,
    AVG(emp_salary) AS avg_salary
    FROM
        employee
    GROUP BY
        emp_gender;
    */
