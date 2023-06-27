package ashina.carrental.business.concretes.usersManagers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ashina.carrental.business.abstracts.userServices.EmployeeService;
import ashina.carrental.dataAccess.abstracts.UsersDaos.EmployeeDao;
import ashina.carrental.entities.concretes.users.Employee;

@Service
public class EmployeeManager implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * Registers a new employee by saving the employee object using the employeeDao.
     * @param employee The employee to be registered.
     * @return The registered employee.
     */
    @Override
    public Employee registerNewEmployee(Employee employee) {
       return employeeDao.save(employee);
    }

     /**
     * Retrieves a list of all employees from the data source using the employeeDao.
     * @return A list of all employees.
     */
    @Override
    public List<Employee> getAllEmployees() {
       return employeeDao.findAll();
    }

     /**
     * Retrieves an employee by their ID from the data source using the employeeDao.
     * @param id The ID of the employee to retrieve.
     * @return An optional containing the employee if found, or empty if not found.
     */
   @Override
   public Optional<Employee> findById(int id) {
      return employeeDao.findById(id);
   }

   /**
    * Retrieves an employee by their email from the data source using the employeeDao.
    * @param email The email of the employee to retrieve.
    * @return An optional containing the employee if found, or empty if not found.
    */
   @Override
   public Optional<Employee> findByEmail(String email) {
      return employeeDao.findByEmail(email);   
   }

   /**
    * Retrieves an employee by their national identification number from the data source using the employeeDao.
    * @param nationalIdentificationNumber The national identification number of the employee to retrieve.
    * @return An optional containing the employee if found, or empty if not found.
    */
   @Override
   public Optional<Employee> findByNationalIdentificationNumber(String nationalIdentificationNumber) {
      return employeeDao.findByNationalIdentificationNumber(nationalIdentificationNumber);
   }

    /**
    * Checks if an employee with the given email exists in the data source using the employeeDao.
    * @param email The email to check.
    * @return True if an employee with the given email exists, false otherwise.
    */
   @Override
   public boolean existsByEmail(String email) {
      return employeeDao.existsByEmail(email);
   }

   /**
    * Deletes an employee by their ID from the data source using the employeeDao.
    * @param id The ID of the employee to delete.
    */
   @Override
   public void deleteById(int id) {
      employeeDao.deleteById(id);
   }

   /**
    * Checks if an employee with the given national identification number exists in the data source using the employeeDao.
    * @param nationalIdentificationNumber The national identification number to check.
    * @return True if an employee with the given national identification number exists, false otherwise.
    */
   @Override
   public boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber) {
     return employeeDao.existsByNationalIdentificationNumber(nationalIdentificationNumber);
   }

    /**
    * Updates an employee by saving the updated employee object using the employeeDao.
    * @param employee The updated employee object.
    * @return The updated employee.
    * @throws RuntimeException if the employee to be updated is not found.
    */
   @Override
   public Employee updateEmployee(Employee employee) {

      Optional<Employee> existingEmployee = employeeDao.findById(employee.getId());

      if (existingEmployee.isPresent()) {
         Employee updatetedEmployee = employeeDao.save(employee);
         return updatetedEmployee;
      } else {
         throw new RuntimeException("Employee not found.");
      }
   }
    
}
