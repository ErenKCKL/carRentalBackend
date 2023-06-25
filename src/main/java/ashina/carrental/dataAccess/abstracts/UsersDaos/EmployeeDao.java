package ashina.carrental.dataAccess.abstracts.UsersDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

    
    
}
