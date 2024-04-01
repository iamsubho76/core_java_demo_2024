package com.org.core.stream_grouping_sql.demo.v1.program_quries;

import com.org.core.stream_grouping_sql.demo.v1.model.EmployeeObject;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class C4_HighestPaid {
    public static void main(String[] args) {
        // Find Highest
        Optional<EmployeeObject> highestSalary = EmployeeObject.getListOfEmployee().stream()
                .collect(
                        Collectors.maxBy(
                                Comparator.comparingDouble(EmployeeObject::getEmp_salary)));
        System.out.println(highestSalary.get().getEmp_name());

        System.out.println("==============================================================================================================================================================================================================================================================================================================================================================");
        // Find Nth highest suppose for below example 3rd
        // Find nth highest salary
        int n = 3; // Change n to find different nth highest salary
        Optional<Double> nthHighestSalary = EmployeeObject.getListOfEmployee().stream()
                .map(EmployeeObject::getEmp_salary)
                .distinct() // Remove duplicates, if any
                .sorted((sal1, sal2) -> Double.compare(sal2, sal1)) // Sort in descending order
                .skip(n - 1) // Skip first n-1 salaries
                .findFirst(); // Get the nth highest salary

        // Print the result
        if (nthHighestSalary.isPresent()) {
            System.out.println("The " + n + "th highest salary is: " + nthHighestSalary.get());
        } else {
            System.out.println("No such rank exists in the given list.");
        }
    }
    //SQL
    /*
    V1. Highest Paid
    SELECT *
    FROM employee
    WHERE emp_salary = (SELECT MAX(emp_salary) FROM employee);

    V2.Using the LIMIT & Offset Clause
    SELECT *
    FROM employee
    ORDER BY emp_salary DESC
    LIMIT 1 OFFSET 4;

    V3. Using the LIMIT Clause but without offset
    SELECT *
    FROM employee
    WHERE emp_salary = (
        SELECT MAX(emp_salary)
        FROM (
            SELECT emp_salary
            FROM employee
            ORDER BY emp_salary DESC
            LIMIT 5
        ) AS subquery
    );

    V4. Using ROW_NUMBER():: This function assigns a unique sequential integer to each row
    within the partition, starting from 1. If there are ties in the ordering criteria,
    ROW_NUMBER() will assign different numbers to each tied row, ensuring that each row
    receives a unique rank.
    Example:
    ROW_NUMBER  Salary
    1           5000
    2           4500
    3           4500
    4           4000


    SELECT *
    FROM (
        SELECT emp_id, emp_name, emp_age, emp_gender, emp_dep, year_of_joining, emp_salary,
               ROW_NUMBER() OVER (ORDER BY emp_salary DESC) AS row_num
        FROM employee
    ) ranked_employees
    WHERE row_num = 5;


    V5. Using RANK():: This function assigns the same rank to rows with the same value in the
    ordering criteria, leaving gaps in the ranking sequence when ties occur. If multiple
    rows have the same value, they are assigned the same rank, and the next rank after that
    is adjusted accordingly.

    Example:
    RANK  Salary
    1     5000
    2     4500
    2     4500
    4     4000

    SELECT *
    FROM (
        SELECT emp_id, emp_name, emp_age, emp_gender, emp_dep, year_of_joining, emp_salary,
               RANK() OVER (ORDER BY emp_salary DESC) AS salary_rank
        FROM employee
    ) ranked_employees
    WHERE salary_rank = 5;


    V6. Using DENSE_RANK():: This function also assigns the same rank to rows with the same
    value in the ordering criteria, but it does not leave gaps in the ranking sequence
    when ties occur. It produces a dense ranking where the ranks are consecutive integers
    without gaps.

    Example:
    DENSE_RANK  Salary
    1           5000
    2           4500
    2           4500
    3           4000

    SELECT *
    FROM (
        SELECT emp_id, emp_name, emp_age, emp_gender, emp_dep, year_of_joining, emp_salary,
               DENSE_RANK() OVER (ORDER BY emp_salary DESC) AS salary_dense_rank
        FROM employee
    ) ranked_employees
    WHERE salary_dense_rank = 5;
    */
}
