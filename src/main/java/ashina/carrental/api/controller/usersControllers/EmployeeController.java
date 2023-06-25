package ashina.carrental.api.controller.usersControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ashina.carrental.business.abstracts.userServices.EmployeeService;
import ashina.carrental.entities.concretes.users.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/register")
    public ResponseEntity<Employee> registerNewEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.registerNewEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }
}
