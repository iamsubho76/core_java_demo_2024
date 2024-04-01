package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Comparator;
import java.util.Optional;

public class C9_MostExpEmp {
    public static void main(String[] args) {
        Optional<EmployeeObject> mostSeniorEmployee =
                EmployeeObject.getListOfEmployee().stream().sorted(Comparator.comparingInt(EmployeeObject::getYear_of_joining))
                        .findFirst();
        EmployeeObject oneSeniorEmployee = mostSeniorEmployee.get();
        System.out.println("ID : "+oneSeniorEmployee.getEmp_id());
        System.out.println("Name : "+oneSeniorEmployee.getEmp_name());
        System.out.println("Joining Year "+oneSeniorEmployee.getYear_of_joining());
    }
}

    // SQL
    /*
    SELECT emp_name, (YEAR(CURRENT_DATE) - year_of_joining) AS work_experience
    FROM employee
    ORDER BY work_experience DESC
    LIMIT 1;
    */
