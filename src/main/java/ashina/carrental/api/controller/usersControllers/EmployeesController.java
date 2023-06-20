package ashina.carrental.api.controller.usersControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ashina.carrental.business.abstracts.userServices.EmployeesService;
import ashina.carrental.entities.concretes.users.Employees;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {
    
    // This class serves as the controller for employee-related API endpoints
    

    @Autowired
    private EmployeesService employeesService; // Injects an instance of the UsersService interface for handling user operations

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        // This method handles GET requests to the "/api/users/getAllEmployees" URL

        // Retrieve all users by calling the getAllEmpployees() method of the EmployeesService interface
        List<Employees> allEmployees = employeesService.getAllEmployees();

        // Return a ResponseEntity with the retrieved users and  HTTP 200 status  
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Employees> findById(@PathVariable int id){
        return employeesService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

}
