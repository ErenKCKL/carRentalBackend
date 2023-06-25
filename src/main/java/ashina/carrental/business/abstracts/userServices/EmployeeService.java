package ashina.carrental.business.abstracts.userServices;

import java.util.List;

import ashina.carrental.entities.concretes.users.Employee;

public interface EmployeeService {

    Employee registerNewEmployee(Employee employee);
    
    List<Employee> getAllEmployees();
    
}
