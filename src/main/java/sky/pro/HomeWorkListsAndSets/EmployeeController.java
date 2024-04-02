package sky.pro.HomeWorkListsAndSets;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    EmployeeServiceImpl employeeService1 = new EmployeeServiceImpl();

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException exception) {
            return "Список сотрудников полон";
        } catch (EmployeeAlreadyAddedException exception) {
            return "Такой сотрудник уже есть";
        }
        Employee employee = new Employee(firstName, lastName);
        return employee.toString();
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        try {
            employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException exception) {
            return "Сотрудник не найден";
        }
        return "Сотрудник " + firstName + " " + lastName + " удален!";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        try {
            employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException exception) {
            return "Сотрудник не найден";
        }
        return "Сотрудник " + firstName + " " + lastName;
    }

    @GetMapping(path = "/all")
    public String printAllEmployees() {
        return employeeService1.employeeList.toString();
    }
}
