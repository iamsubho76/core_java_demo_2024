package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Map;
import java.util.stream.Collectors;

public class C6_EmpWorkInEachDept {
    public static void main(String[] args) {
        Map<String, Long> departmentCount = EmployeeObject.getListOfEmployee().stream()
                .collect(Collectors.groupingBy(
                        EmployeeObject::getEmp_dep, Collectors.counting()));

        for (Map.Entry<String, Long> entry : departmentCount.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    //SQL
    /*

    V1.
    SELECT emp_dep, COUNT(*) AS num_of_employees
    FROM employee
    GROUP BY emp_dep;

    V2. if emp and dept are two different table need to do join

    SELECT d.dept_name, COUNT(e.emp_id) AS num_of_employees
    FROM employee e
    INNER JOIN department d ON e.dept_id = d.dept_id
    GROUP BY d.dept_name;
    */
}
