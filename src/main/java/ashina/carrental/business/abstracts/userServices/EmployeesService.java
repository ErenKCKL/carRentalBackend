package ashina.carrental.business.abstracts.userServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ashina.carrental.entities.concretes.users.Employees;

public interface EmployeesService {

    List<Employees> getAllEmployees();

    Optional<Employees> findById(int id);

    Optional<Employees> findByEmail(String email);

    Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber);

    Optional<Employees> findByEmployeeNumber(UUID employeeNumber);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber);

    boolean existsByEmployeeNumber(UUID employeeNumber);

}
