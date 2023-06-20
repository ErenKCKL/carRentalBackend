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

    @Autowired
    private EmployeesDao employeesDao;

    @Override
    public List<Employees> getAllEmployees() {
        return employeesDao.findAll();
    }

    @Override
    public Optional<Employees> findById(int id) {
        return employeesDao.findById(id);
    }

    @Override
    public Optional<Employees> findByEmail(String email) {
        return employeesDao.findByEmail(email);
    }

    @Override
    public Optional<Employees> findByNationalIdentificationNumber(String nationalIdentificationNumber) {
        return employeesDao.findByNationalIdentificationNumber(nationalIdentificationNumber);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employeesDao.existsByEmail(email);
    }

    @Override
    public boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber) {
        return employeesDao.existsByNationalIdentificationNumber(nationalIdentificationNumber);
    }

    @Override
    public Optional<Employees> findByEmployeeNumber(UUID employeeNumber) {
        return employeesDao.findByEmployeeNumber(employeeNumber);
    }

    @Override
    public boolean existsByEmployeeNumber(UUID employeeNumber) {
        return employeesDao.existsByEmployeeNumber(employeeNumber);
    }

}
