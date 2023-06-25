package ashina.carrental.business.concretes.usersManagers;

import java.util.List;

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
    
}
