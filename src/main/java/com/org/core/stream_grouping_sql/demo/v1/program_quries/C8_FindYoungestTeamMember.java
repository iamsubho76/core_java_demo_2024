package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Comparator;
import java.util.Optional;

public class C8_FindYoungestTeamMember {
    public static void main(String[] args) {
        Optional<EmployeeObject> youngEmployee=
                EmployeeObject.getListOfEmployee().stream()
                        .filter(e -> e.getEmp_gender()=="Male" && e.getEmp_dep()=="Development")
                        .min(Comparator.comparingInt(EmployeeObject::getEmp_age));
        EmployeeObject youngMaleEmployee = youngEmployee.get();

        System.out.println("ID : "+youngMaleEmployee.getEmp_id());
        System.out.println("Name : "+youngMaleEmployee.getEmp_name());
    }

    //SQL
    /*
    SELECT emp_name, MIN(emp_age) AS min_age
    FROM employee
    WHERE emp_dep = 'Development' AND emp_gender = 'male'
    GROUP BY emp_name
    ORDER BY min_age ASC
    LIMIT 1;

     */
}
