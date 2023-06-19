package ashina.carrental.business.concretes.usersManagers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ashina.carrental.business.abstracts.userServices.UsersService;
import ashina.carrental.dataAccess.abstracts.UsersDaos.UsersDao;
import ashina.carrental.entities.concretes.users.Users;

@Service
public class UsersManager implements UsersService {

    // This class implements the UsersService interface and serves as the business
    // logic layer for user operations

    @Autowired
    private UsersDao usersDao; // Injects an instance of the UsersDao interface for data access

    @Override
    public List<Users> getAllUsers() {
        return usersDao.findAll(); // Retrieves all users by calling the findAll() method of the UsersDao interface
    }

    @Override
    public Optional<Users> findById(int id) {
        return usersDao.findById(id); // Finds a user by their ID by calling the findById() method of the UsersDao
                                      // interface
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return usersDao.findByEmail(email); // Finds a user by their email address by calling the findByEmail() method
                                            // of the UsersDao interface
    }

    @Override
    public boolean existsByEmail(String email) {
        return usersDao.existsByEmail(email); // Checks if a user with the specified email address exists by calling the
                                              // existsByEmail() method of the UsersDao interface
    }

}
