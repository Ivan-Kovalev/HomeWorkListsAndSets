package sky.pro.HomeWorkListsAndSets;

import org.springframework.stereotype.Service;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);

    void printAllEmployees();
}
