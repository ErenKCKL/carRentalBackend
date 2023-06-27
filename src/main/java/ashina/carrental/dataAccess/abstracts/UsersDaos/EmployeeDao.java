package ashina.carrental.dataAccess.abstracts.UsersDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Employee;
import java.util.Optional;


public interface EmployeeDao extends JpaRepository<Employee, Integer>{

    Optional<Employee> findById(int id);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByNationalIdentificationNumber(String nationalIdentificationNumber);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);
    
    
}
