package ashina.carrental.business.abstracts.userServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ashina.carrental.entities.concretes.users.Employees;

public interface EmployeesService {
    // This interface defines the contract for user-related operations in the service layer

    List<Employees> getAllEmployees();
    // Retrieves all employees
    // Return a list of Employees objects

    Optional<Employees> findById(int id);
    // Finds a employee by their ID
    // Takes an integer ID as a parameter
    // Returns an Optional that may contain the employee with the specified ID

    Optional<Employees> findByEmail(String email);
    // Finds a employee by their email address
    // Takes a string email as a parameter
    // Returns an Optional that may contain the employee with the specified email address

    Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber);
    // Finds a employee by their national identification number
    // Takes a string national identification number as a parameter
    // Returns an Optional that may contain the employee with the specified national identification number

    Optional<Employees> findByEmployeeNumber(UUID employeeNumber);
    // Finds a employee by their employee number
    // Takes a UUID employee number as a parameter
    // Returns an Optional that may contain the employee with the specified employee number

    boolean existsByEmail(String email);
    // Checks if a employee with the specified email address exists
    // Takes a string email as a parameter 
    // Returns true if a employee with the specified email address exists, false otherwise

    boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);
    // Checks if a employee with the specified national identification number
    // Takes a string national identification number as a parameter 
    // Returns true if a employee with the specified national identification number exists, false otherwise

    boolean existsByEmployeeNumber(UUID employeeNumber);
    // Checks if a employee with the specified employee number
    // Takes a string employee number as a parameter 
    // Returns true if a employee with the specified employee number exists, false otherwise

}
