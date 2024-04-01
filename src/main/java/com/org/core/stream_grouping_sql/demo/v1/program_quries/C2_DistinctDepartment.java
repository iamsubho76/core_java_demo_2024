package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

public class C2_DistinctDepartment {
    public static void main(String[] args) {
        EmployeeObject.getListOfEmployee().stream().map(EmployeeObject::getEmp_dep).distinct()
                .forEach(System.out::println);
    }
    //SQL
    /*
    SELECT DISTINCT emp_dep
    FROM employee;
    */
}
