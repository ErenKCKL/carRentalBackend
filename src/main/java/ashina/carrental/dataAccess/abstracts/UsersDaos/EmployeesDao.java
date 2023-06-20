package ashina.carrental.dataAccess.abstracts.UsersDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Employees;
import java.util.Optional;
import java.util.UUID;

public interface EmployeesDao extends JpaRepository<Employees, Integer> {

   Optional<Employees> findById(int id);
   // Method signature to find a employee by their ID
   // Returns an Optional that may contain the employee with the specified ID


   Optional<Employees> findByEmail(String email);
   // Method signature to find a employee by their email address
   // Returns an Optional that may contain the employee with the specified email address

   Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber);
   // Method signature to find a employee by their national identification number
   // Returns an Optional that may contain the employee with the specified national identification number


   Optional<Employees> findByEmployeeNumber(UUID employeeNumber);
   // Method signature to find a employee by their employee number
   // Returns an Optional that may contain the employee with the specified employee number

   boolean existsByEmail(String email);
   // Method signature to check if a employee exists with the specified email address
   // Returns true if a employee with the specified email address exists, false otherwise

   boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);
   // Method signature to check if a employee exists with the specified national identification number
   // Returns true if a employee with the specified national identification number exists, false otherwise

   boolean existsByEmployeeNumber(UUID employeeNumber);
   // Method signature to check if a employee exists with the specified employee number
   // Returns true if a employee with the specified employee number exists, false otherwise

}
