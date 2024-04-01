package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C13_EmpBelowAndAboveCertainAge {
    public static void main(String[] args) {
        Map<Boolean, List<EmployeeObject>> groupByage =
                EmployeeObject.getListOfEmployee().stream().collect(Collectors.partitioningBy(e -> e.getEmp_age() > 25));
        for (Map.Entry<Boolean, List<EmployeeObject>> entry : groupByage.entrySet())
        {
            if (entry.getKey())
                System.out.println("Age Greater than 25 years :");
            else
                System.out.println("Age less than or Equal to 25 years :");
            List<EmployeeObject> list = entry.getValue();

            for (EmployeeObject e : list)
            {
                System.out.println(e.getEmp_name());
            }
        }
    }

    //SQL
    /*
    SELECT
    emp_name,
    emp_age,
    CASE
        WHEN emp_age < 25 THEN 'Under 25'
        ELSE 'Over 25'
    END AS age_group
    FROM
        employee
    ORDER BY
        age_group;

     */
}
