package ashina.carrental.business.abstracts.userServices;

import java.util.List;
import java.util.Optional;

import ashina.carrental.entities.concretes.users.Employee;

public interface EmployeeService {

    Employee registerNewEmployee(Employee employee);

    void deleteById(int id);
    
    List<Employee> getAllEmployees();

    Optional<Employee> findById(int id);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByNationalIdentificationNumber(String nationalIdentificationNumber);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);
    
}
