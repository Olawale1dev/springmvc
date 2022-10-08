package in.sodiq.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "employees")

public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;
    @Column( name ="First_Name")
    private String FirstName;
    @Column( name ="Last_Name")
    private String LastName;
    @Column( name ="Email")
    private String Email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
