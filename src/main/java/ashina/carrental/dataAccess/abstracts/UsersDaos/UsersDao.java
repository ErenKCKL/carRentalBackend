package ashina.carrental.dataAccess.abstracts.UsersDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Users;
import java.util.List;
import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Integer> {

    Optional<Users> findById(int id);

    Optional<Users> findByEmail(String email);

}
