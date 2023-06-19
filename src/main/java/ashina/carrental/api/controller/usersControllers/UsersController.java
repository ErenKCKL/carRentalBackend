package ashina.carrental.api.controller.usersControllers;

import org.apache.catalina.connector.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ashina.carrental.business.abstracts.userServices.UsersService;
import ashina.carrental.entities.concretes.users.Users;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Users>> getAllUsers() {

        // Getting all user from database

        List<Users> allUsers = usersService.getAllUsers();
        return new ResponseEntity(allUsers, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Users> findById(@PathVariable int id) {

        // This method defines an API endpoint to search for a user by id
        // Handle GET requests to the "/find-by-id/{id}" URL
        // The {id} URL parameter represents the id to search for

        return usersService.findById(id)
                .map(ResponseEntity::ok) // If a user is found, wrap it in a ResponseEntity with HTTP 200 status
                .orElse(ResponseEntity.notFound().build()); // If no user is found, return HTTP 404 status
    }

    @GetMapping("find-by-email/{email}")
    public ResponseEntity<Users> findByEmail(@PathVariable String email) {

        // This method defines an API endpoint to search for a user by email address
        // Handle GET requests to the "/find-by-email/{email}" URL
        // The {email} URL parameter represents the email address to search for

        return usersService.findByEmail(email)
                .map(ResponseEntity::ok) // If a user is found, wrap it in a ResponseEntity with HTTP 200 status
                .orElse(ResponseEntity.notFound().build()); // If no user is found, return HTTP 404 status
    }

    @GetMapping("/exists-by-email/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        // This method defines an API endpoint to check if a user exists by email
        // address
        // Handle GET requests to the "/exists-by-email/{email}" URL
        // The {email} URL parameter represents the email address to check

        boolean exists = usersService.existsByEmail(email); // Check if a user with the given email exists

        if (exists) {
            // If a user exists with the given email, return HTTP 200 with body containing
            // "true"
            return ResponseEntity.ok(true);
        } else {
            // If no user exists with the given email, return HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }

    }

}
