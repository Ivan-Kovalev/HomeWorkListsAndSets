package sky.pro.HomeWorkListsAndSets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> employeeList = new ArrayList<>();
    public final int employeeSize = 3;

    @Override
    public void addEmployee(String firstName, String lastName) {
        if (employeeList.size() >= employeeSize) {
            throw new EmployeeStorageIsFullException("Список сотрудников полон");
        }
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
            }
        }
        Employee employee = new Employee(firstName, lastName);
        employeeList.add(employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employeeList.remove(employee);
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                System.out.println(employee);
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
    }

    @Override
    public void printAllEmployees() {
        System.out.println(employeeList);
    }
}
