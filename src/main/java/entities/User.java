package entities;

import javax.persistence.*;

@Entity
@Table(name = ITables.USER_TABLE)
@NamedQuery(name = "User.findAll", query = "Select u FROM User u")
public class User extends BaseEntity {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;


    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
}
