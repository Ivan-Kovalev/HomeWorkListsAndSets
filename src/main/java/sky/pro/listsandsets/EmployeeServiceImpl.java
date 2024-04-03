package sky.pro.listsandsets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int employeeSize = 3;
    private final List<Employee> employeeList = new ArrayList<>(employeeSize);

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.size() >= employeeSize) {
            throw new EmployeeStorageIsFullException("Список сотрудников полон");
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
