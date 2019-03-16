package entities.residence;

import entities.tables.ITables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = ITables.RESIDENCE_TABLE)
@NamedQuery(name = "Residence.findAll", query = "Select r FROM ResidenceEntity r")
public class ResidenceEntity extends BaseEntityResidence{

    @Column(name = "place")
    private int place;
    @Column(name = "street")
    private String street;
    @Column(name = "address")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
