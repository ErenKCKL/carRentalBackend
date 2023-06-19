package ashina.carrental.business.abstracts.userServices;

import java.util.List;
import java.util.Optional;

import ashina.carrental.entities.concretes.users.Users;

public interface UsersService {

    List<Users> getAllUsers();

    Optional<Users> findById(int id);

    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);

}
