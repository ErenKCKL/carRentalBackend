package ashina.carrental.dataAccess.abstracts.UsersDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Employees;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface EmployeesDao extends JpaRepository<Employees, Integer> {

   Optional<Employees> findById(int id);

   Optional<Employees> findByEmail(String email);

   Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber);

   Optional<Employees> findByEmployeeNumber(UUID employeeNumber);

   boolean existsByEmail(String email);

   boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);

   boolean existsByEmployeeNumber(UUID employeeNumber);

}
