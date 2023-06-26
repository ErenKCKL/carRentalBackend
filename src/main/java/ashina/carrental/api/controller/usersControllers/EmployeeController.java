package ashina.carrental.api.controller.usersControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ashina.carrental.business.abstracts.userServices.EmployeeService;
import ashina.carrental.entities.concretes.users.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/register")
    public ResponseEntity<Employee> registerNewEmployee(@RequestBody Employee employee){

         if (employeeService.existsByEmail(employee.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already registered.");
        }

        if (employeeService.existsByNationalIdentificationNumber(employee.getNationalIdentificationNumber())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "National Identification Number already registered.");
        }

        Employee savedEmployee = employeeService.registerNewEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id){
        return employeeService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Employee> findByEmail(@PathVariable String email){
        return employeeService.findByEmail(email)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByNationalIdentificationNumber/{nationalIdentificationNumber}")
    public ResponseEntity<Employee> findByNationalIdentificationNumber(@PathVariable String nationalIdentificationNumber){
        return employeeService.findByNationalIdentificationNumber(nationalIdentificationNumber)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){
        boolean exists = employeeService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/existsByNationalIdentificationNumber/{nationalIdentificationNumber}")
    public ResponseEntity<Boolean> existsByNationalIdentificationNumber(@PathVariable String nationalIdentificationNumber){
        boolean exists = employeeService.existsByNationalIdentificationNumber(nationalIdentificationNumber);
        return ResponseEntity.ok(exists);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        return employeeService.findById(id).map(employee -> {
            employeeService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
