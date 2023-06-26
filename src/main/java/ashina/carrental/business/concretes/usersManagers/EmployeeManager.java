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

    @Override
    public Employee registerNewEmployee(Employee employee) {
       return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeDao.findAll();
    }

   @Override
   public Optional<Employee> findById(int id) {
      return employeeDao.findById(id);
   }

   @Override
   public Optional<Employee> findByEmail(String email) {
      return employeeDao.findByEmail(email);   
   }

   @Override
   public Optional<Employee> findByNationalIdentificationNumber(String nationalIdentificationNumber) {
      return employeeDao.findByNationalIdentificationNumber(nationalIdentificationNumber);
   }

   @Override
   public boolean existsByEmail(String email) {
      return employeeDao.existsByEmail(email);
   }

   @Override
   public void deleteById(int id) {
      employeeDao.deleteById(id);
   }

   @Override
   public boolean existsByNationalIdentificationNumber(String nationalIdentificationNumber) {
     return employeeDao.existsByNationalIdentificationNumber(nationalIdentificationNumber);
   }
    
}
