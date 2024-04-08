package sky.pro.listsandsets.service;

import sky.pro.listsandsets.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    List<Employee> getEmployeeList();
}
