package entities.residence;

import entities.tables.ITables;
import entities.user.UserEntity;
import models.user.User;

import javax.persistence.*;

@Entity
@Table(name = ITables.RESIDENCE_TABLE)
@NamedQuery(name = "Residence.findAll", query = "Select r FROM ResidenceEntity r")
public class ResidenceEntity extends BaseEntityResidence{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id_fk")
    private UserEntity user;

    @Column(name = "place")
    private int place;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
