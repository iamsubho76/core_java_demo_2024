package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class C10_RatioOfEmpForSalesDept {
    public static void main(String[] args) {
        Map<String, Long> totalCountInSales =
                EmployeeObject.getListOfEmployee().stream()
                        .filter(e -> e.getEmp_dep()=="Sales")
                        .collect(Collectors.groupingBy(EmployeeObject::getEmp_gender, Collectors.counting()));
        System.out.println(totalCountInSales);
    }
}

    // SQL
    /*
    SELECT
        SUM(CASE WHEN emp_gender = 'male' THEN 1 ELSE 0 END) AS male_count,
        SUM(CASE WHEN emp_gender = 'female' THEN 1 ELSE 0 END) AS female_count,
        CASE
            WHEN SUM(CASE WHEN emp_gender = 'female' THEN 1 ELSE 0 END) = 0 THEN 0
            ELSE SUM(CASE WHEN emp_gender = 'male' THEN 1 ELSE 0 END) / SUM(CASE WHEN emp_gender = 'female' THEN 1 ELSE 0 END)
        END AS male_female_ratio
    FROM
        employee
    WHERE
        emp_dep = 'Sales';
    */
