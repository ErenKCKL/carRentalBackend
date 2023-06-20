package ashina.carrental.business.concretes.usersManagers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ashina.carrental.business.abstracts.userServices.EmployeesService;
import ashina.carrental.dataAccess.abstracts.UsersDaos.EmployeesDao;
import ashina.carrental.entities.concretes.users.Employees;

@Service
public class EmployeesManager implements EmployeesService {

    // This class implements the UsersService interface and serves as the business logic layer for user operations

    @Autowired
    private EmployeesDao employeesDao; // Injects an instance of the EmployeesDao interface for data access

    @Override
    public List<Employees> getAllEmployees() {
        return employeesDao.findAll(); // Retrieves all employees by calling the findAll() method of the EmployeesDao interface
    }

    @Override
    public Optional<Employees> findById(int id) {
        // Finds a employee by their ID by calling the findById() method of the EmployeesDao interface
        return employeesDao.findById(id); 
    }

    @Override
    public Optional<Employees> findByEmail(String email) {
        // Finds a employee by their email by calling the findByEmail() method of the EmployeesDao interface
        return employeesDao.findByEmail(email);
    }

    @Override
    public Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber) {
        // Finds a employee by their national identidication number by calling the findByNationalIdentificationNumber() method of the EmployeesDao interface
        return employeesDao.findByNationalIdentificationNumber(nationalIdentificationNumber);
    }

    @Override
    public boolean existsByEmail(String email) {
        // Checks if a employee with the specified email address exists by calling the existsByEmail() method of the EmployeesDao interface
        return employeesDao.existsByEmail(email);
    }

    @Override
    public boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber) {
        return employeesDao.existsByNationalIdentificationNumber(nationalIdentificationNumber);
    }

    @Override
    public Optional<Employees> findByEmployeeNumber(UUID employeeNumber) {
        // Finds a employee by their employee number by calling the findByEmployeeNumber() method of the EmployeesDao interface
        return employeesDao.findByEmployeeNumber(employeeNumber);
    }

    @Override
    public boolean existsByEmployeeNumber(UUID employeeNumber) {
        // Checks if a employee with the specified employee number address exists by calling the existsByEmployeeNumber() method of the EmployeesDao interface
        return employeesDao.existsByEmployeeNumber(employeeNumber);
    }

}
