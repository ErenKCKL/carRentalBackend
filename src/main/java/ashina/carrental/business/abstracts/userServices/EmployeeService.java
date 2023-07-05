package ashina.carrental.business.abstracts.userServices;

import java.util.List;
import java.util.Optional;

import ashina.carrental.entities.concretes.users.Employee;

public interface EmployeeService {

    /**
     * Registers a new employee.
     *
     * @param employee the employee to register
     * @return the registered employee
     */
    Employee registerNewEmployee(Employee employee);

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     */
    void deleteById(int id);

    /**
     * Updates an employee.
     *
     * @param employee the updated employee
     * @return the updated employee
     */
    Employee updateEmployee(Employee employee);
    
    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieves an employee by their unique identifier (ID).
     *
     * @param id the employee ID
     * @return an Optional containing the employee, or an empty Optional if not found
     */
    Optional<Employee> findById(int id);

     /**
     * Retrieves an employee by their email.
     *
     * @param email the employee email
     * @return an Optional containing the employee, or an empty Optional if not found
     */
    Optional<Employee> findByEmail(String email);

     /**
     * Retrieves an employee by their national identification number.
     *
     * @param nationalIdentificationNumber the employee national identification number
     * @return an Optional containing the employee, or an empty Optional if not found
     */
    Optional<Employee> findByNationalIdentificationNumber(String nationalIdentificationNumber);

    /**
     * Checks if an employee with the given email exists.
     *
     * @param email the employee email
     * @return true if an employee with the email exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Checks if an employee with the given national identification number exists.
     *
     * @param nationalIdentificationNumber the employee national identification number
     * @return true if an employee with the national identification number exists, false otherwise
     */
    boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);
    
}
