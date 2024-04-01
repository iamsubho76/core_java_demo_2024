package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Map;
import java.util.stream.Collectors;

public class C1_CountGender {
    public static void main(String[] args) {
        Map<String, Long> countOfEmployee = EmployeeObject.getListOfEmployee().stream()
                .collect(Collectors.groupingBy(EmployeeObject::getEmp_gender, Collectors.counting()));
        System.out.println(countOfEmployee);
    }
    //SQL
    /*SELECT
            emp_gender,
    COUNT(*) AS count
    FROM
            employee
    GROUP BY
    emp_gender;
    */
}
