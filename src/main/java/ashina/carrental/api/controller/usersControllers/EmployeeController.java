package ashina.carrental.api.controller.usersControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ashina.carrental.business.abstracts.userServices.EmployeeService;
import ashina.carrental.entities.concretes.users.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // This class serves as the controller for employee-related API endpoints

    // Injects an instance of the EmployeService interface for handling user operations
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/register")
    public ResponseEntity<Employee> registerNewEmployee(@RequestBody Employee employee){
        // This method handles POST requests to the "/api/employees/register" URL and registers a new employee 

         if (employeeService.existsByEmail(employee.getEmail())) {
            // Check if an employee with the given email already exists
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already registered.");
                    // If the email is already registered, throw a BadRequest exception with a custom error message
        }

        if (employeeService.existsByNationalIdentificationNumber(employee.getNationalIdentificationNumber())) {
            // Check if an employee with the given national identification number already exists
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "National Identification Number already registered.");
                    // If the national identification number is already registered, throw a BadRequest exception with a custom error message
        }

        // Register the new employee by calling the registerNewEmployee() method of the EmployeeService interface
        Employee savedEmployee = employeeService.registerNewEmployee(employee);

        // Return a ResponseEntity with the saved employee and HTTP 200 status
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,){
        
        // This method handles PUT requests to the "/api//updateEmployee" URL and update a employee 

        // Call the updateEmployee method of the employeeService to update the employee
        Employee updatedEmployee = employeeService.updateEmployee(employee);

        // Return the updated employee in the response body with a HTTP 200 OK status
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){

        // This method handles DELETE requests to the "/api/employee/deleteById/{id}" URL to delete an employee by ID

        return employeeService.findById(id).map(employee -> {
            // Find the employee by ID
            employeeService.deleteById(id);

            // Delete the employee by calling the deleteById() method of the EmployeeService interface
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

             // Return a ResponseEntity with HTTP 204 (NO_CONTENT) status to indicate successful deletion
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        // If no employee with the given ID is found, return a ResponseEntity with HTTP 404 (NOT_FOUND) status
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        // This method handles GET requests to the "/api/employees//getAllEmployees" URL

        // Retrieve all users by calling the getAllUsers() method of the EmployeeService interface
        List<Employee> employees = employeeService.getAllEmployees();

        // Return a ResponseEntity with the retrieved users and HTTP 200 status
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id){

        // This method defines an API endpoint to search for a employee by id

        // Handle GET requests to the "findById/{id}" URL

        // The {id} URL parameter represents the id to search for

        return employeeService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Employee> findByEmail(@PathVariable String email){

        // This method defines an API endpoint to search for a employee by email address

        // Handle GET requests to the "findByEmail/{email}" URL

        // The {email} URL parameter represents the email address to search for

        return employeeService.findByEmail(email)
        .map(ResponseEntity::ok) // If a user is found, wrap it in a ResponseEntity with HTTP 200 status
        .orElse(ResponseEntity.notFound().build()); // If no user is found, return HTTP 404 status
    }

    @GetMapping("/findByNationalIdentificationNumber/{nationalIdentificationNumber}")
    public ResponseEntity<Employee> findByNationalIdentificationNumber(@PathVariable String nationalIdentificationNumber){

        // This method defines an API endpoint to search for a employee by national identification number

        // Handle GET requests to the "findByNationalIdentificationNumber/{nationalIdentificationNumber}" URL

        // The {nationalIdentificationNumber} URL parameter represents the email address to search for

        return employeeService.findByNationalIdentificationNumber(nationalIdentificationNumber)
        .map(ResponseEntity::ok) // If a user is found, wrap it in a ResponseEntity with HTTP 200 status
        .orElse(ResponseEntity.notFound().build()); // If no user is found, return HTTP 404 status
    }

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){
        
        // This method defines an API endpoint to check if a employee exists by email address

        // Handle GET requests to the "/exists-by-email/{email}" URL

        // The {email} URL parameter represents the email address to check

        // Check if a user with the given email exists
        boolean exists = employeeService.existsByEmail(email);

        // Return the result as a ResponseEntity with HTTP 200 status
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/existsByNationalIdentificationNumber/{nationalIdentificationNumber}")
    public ResponseEntity<Boolean> existsByNationalIdentificationNumber(@PathVariable String nationalIdentificationNumber){

        // This method defines an API endpoint to check if a employee exists by national identification number

        // Handle GET requests to the "/existsByNationalIdentificationNumber/{nationalIdentificationNumber}" URL

        // The {email} URL parameter represents the email address to check
        
        // Check if a user with the given email exists
        boolean exists = employeeService.existsByNationalIdentificationNumber(nationalIdentificationNumber);

        // Return the result as a ResponseEntity with HTTP 200 status
        return ResponseEntity.ok(exists); 
    }

   

}
