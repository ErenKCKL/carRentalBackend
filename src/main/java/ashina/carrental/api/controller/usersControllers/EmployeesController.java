package ashina.carrental.api.controller.usersControllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        // This method defines an API endpoint to search for a employee by id
        // Handle GET requests to the "/find-by-id/{id}" URL
        // The {id} URL parameter represents the id to search for

        return employeesService.findById(id)
            .map(ResponseEntity::ok) // If a employee is found, wrap it in a ResponseEntity with HTTP 200 status
            .orElse(ResponseEntity.notFound().build()); // If no user is found, return HTTP 404 status
    }

    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<Employees> findByEmail(@PathVariable String email){

        // This method defines an API endpoint to search for a employee by email address
        // Handle GET requests to the "/find-by-email/{email}" URL
        // The {email} URL parameter represents the id to search for
        
        return employeesService.findByEmail(email)
            .map(ResponseEntity::ok) // If a employee is found, wrap it in a ResponseEntity with HTTP 200 status
            .orElse(ResponseEntity.notFound().build()); // If no user is found, return HTTP 404 status
    }

    @GetMapping("/find-by-national-identification-number/{nationalIdentificationNumber}")
    public ResponseEntity<Employees> findByNationalIdentificationNumber(@PathVariable String nationalIdentificationNumber){

        // This method defines an API endpoint to search for a employee by national identification number
        // Handle GET requests to the "/find-by-national-identification-number/{nationalIdentificationNumber}" URL
        // The {nationalIdentificationNumber} URL parameter represents the id to search for

        return employeesService.findByNationalIdentificationNumber(nationalIdentificationNumber)
            .map(ResponseEntity::ok) // If a user is found, wrap it in a ResponseEntity with HTTP 200 status
            .orElse(ResponseEntity.notFound().build()); // If no employee is found, return HTTP 404 status
    }

    @GetMapping("/find-by-employee-number/{employeeNumber}")
    public ResponseEntity<Employees> findByEmployeeNumber(@PathVariable UUID employeeNumber){

        // This method defines an API endpoint to search for a employee by employee number
        // Handle GET requests to the "/find-by-employee-number/{employeeNumber}" URL
        // The {employeeNumber} URL parameter represents the id to search for

        return employeesService.findByEmployeeNumber(employeeNumber)
            .map(ResponseEntity::ok) // If a user is found, wrap it in a ResponseEntity with HTTP 200 status
            .orElse(ResponseEntity.notFound().build()); // If no employee is found, return HTTP 404 status
    }

    @GetMapping("/exists-by-email/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){

        // This method defines an API endpoint to check if a employer exists by email address
        // Handle GET requests to the "/exists-by-email/{email}" URL
        // The {email} URL parameter represents the email address to check

        boolean exists = employeesService.existsByEmail(email); // Check if a employee with the given email exists

        if (exists){
            // If a employee exists with the given email, return HTTP 200 with body containing "true"
            return ResponseEntity.ok(true);
        } else {
            // If no employee exists with the given email, return HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/exists-by-national-identification-number/{nationalIdentificationNumber}")
    public ResponseEntity<Boolean> existsByNationalIdentificationIdentificationNumber(@PathVariable String nationalIdentificationNumber){

        // This method defines an API endpoint to check if a employer exists by national identification number
        // Handle GET requests to the "/exists-by-national-identification-number/{nationalIdentificationNumber}" URL
        // The {nationalIdentificationNumber} URL parameter represents the email address to check

        // Check if a employee with the given national identification number exists
        boolean exists = employeesService.existsByNationalIdentificationNumber(nationalIdentificationNumber);

        if (exists) {
            // If a employee exists with the given national identification number, return HTTP 200 with body containing "true"
            return ResponseEntity.ok(true);
        } else {
            // If no employee exists with the given national identification number, return HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }

    }

}
