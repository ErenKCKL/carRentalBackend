package ashina.carrental.entities.concretes.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "users_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = true)
@Table(name = "employees")
public class Employees extends Users {

    @Column(name = "first_name")
    private String firstName;

}
