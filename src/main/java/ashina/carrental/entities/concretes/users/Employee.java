package ashina.carrental.entities.concretes.users;

import java.time.LocalDate;

import ashina.carrental.entities.concretes.Job;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Email of the employee
    @Column(name = "email")
    private String email;

    // Password of the employee
    @Column(name = "password")
    private String password;

    // Full name of the employee
    @Column(name = "full_name")
    private String fullname;

    // National identification number of the employee
    @Column(name = "national_identification_number")
    private String nationalIdentificationNumber;

    // Date of birth of the employee
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    // Phone number of the employee
    @Column(name = "phone_number")
    private String phoneNumber;

    // Flag indicating whether the employee is verified
    @Column(name = "is_verified")
    private boolean isVerified;

    // Job associated with the employee
    @ManyToOne
    @JoinColumn(name = "job_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Job job;


    // Constructors, getters, setters, toString, equals, and hashCode are generated by Lombok.
    // Additional methods and logic can be added here.

}
