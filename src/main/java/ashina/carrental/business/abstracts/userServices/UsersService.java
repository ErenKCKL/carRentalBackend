package ashina.carrental.business.abstracts.userServices;

import java.util.List;
import java.util.Optional;

import ashina.carrental.entities.concretes.users.Users;

public interface UsersService {
    // This interface defines the contract for user-related operations in the
    // service layer

    List<Users> getAllUsers();
    // Retrieves all users
    // Returns a list of Users objects

    Optional<Users> findById(int id);
    // Finds a user by their ID
    // Takes an integer ID as a parameter
    // Returns an Optional that may contain the user with the specified ID

    Optional<Users> findByEmail(String email);
    // Finds a user by their email address
    // Takes a string email as a parameter
    // Returns an Optional that may contain the user with the specified email
    // address

    boolean existsByEmail(String email);
    // Checks if a user with the specified email address exists
    // Takes a string email as a parameter
    // Returns true if a user with the specified email address exists, false
    // otherwise

}
