package ashina.carrental.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {

}
