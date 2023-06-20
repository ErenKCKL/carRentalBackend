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

    Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber);

    Optional<Employees> findByEmployeeNumber(UUID employeeNumber);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);

    boolean existsByEmployeeNumber(UUID employeeNumber);

}
