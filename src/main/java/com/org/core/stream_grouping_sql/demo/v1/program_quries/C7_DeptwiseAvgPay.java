package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Map;
import java.util.stream.Collectors;

public class C7_DeptwiseAvgPay {
    public static void main(String[] args) {
        Map<String, Double> departmentAvgSalary=
                EmployeeObject.getListOfEmployee().stream()
                        .collect(
                                Collectors.groupingBy(EmployeeObject::getEmp_dep,
                                Collectors.averagingDouble(EmployeeObject::getEmp_salary)));

        for (Map.Entry<String, Double> entry : departmentAvgSalary.entrySet())
            System.out.println(entry.getKey()+" : "+entry.getValue());
    }

    //SQL
    /*

    V1. if emp and dept are two different table need to do join

    SELECT d.dept_name, AVG(e.emp_salary) AS avg_salary
    FROM employee e
    INNER JOIN department d ON e.dept_id = d.dept_id
    GROUP BY d.dept_name;

    */
}
