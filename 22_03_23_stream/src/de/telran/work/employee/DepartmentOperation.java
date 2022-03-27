package de.telran.work.employee;

import java.util.List;

public class DepartmentOperation {

    public int function(List<Department> accounts,String code, long threshold){



                return (int) accounts.stream()
                        .filter(department -> department.getCode().startsWith(code))
                        .flatMap(department -> department.getEmployees().stream())
                        .filter(employee -> employee.getSalary() >= threshold)
                        .count();
            }


    
}
