package entities.user;

import entities.tables.ITables;

import javax.persistence.*;

@Entity
@Table(name = ITables.USER_TABLE)
@NamedQuery(name = "User.findAll", query = "Select u FROM UserEntity u")
public class UserEntity extends BaseEntityUser {

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
