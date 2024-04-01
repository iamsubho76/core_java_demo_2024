package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C12_NameOfEmpBasedOnDept {
    public static void main(String[] args) {
        Map<String, List<EmployeeObject>> employeeListByDepartment=
                EmployeeObject.getListOfEmployee().stream().collect(Collectors.groupingBy(EmployeeObject::getEmp_dep));

        for (Map.Entry<String, List<EmployeeObject>> entry : employeeListByDepartment.entrySet())
        {
            System.out.println("Department Name is "+entry.getKey());

            List<EmployeeObject> list = entry.getValue();

            for (EmployeeObject e : list)
            {
                System.out.println(e.getEmp_name());
            }
        }
    }
}

    // SQL
    /*
    SELECT emp_name, emp_dep
    FROM employee
    ORDER BY emp_dep;

    */
