package ashina.carrental.dataAccess.abstracts.UsersDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import ashina.carrental.entities.concretes.users.Users;
import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Integer> {
    // This interface extends the JpaRepository interface, providing basic CRUD operations for the Users entity
    
    Optional<Users> findById(int id);
    // Method signature to find a user by their ID
    // Returns an Optional that may contain the user with the specified ID

    Optional<Users> findByEmail(String email);
    // Method signature to find a user by their email address
    // Returns an Optional that may contain the user with the specified email address

    boolean existsByEmail(String email);
    // Method signature to check if a user exists with the specified email address
    // Returns true if a user with the specified email address exists, false otherwise
    
}
