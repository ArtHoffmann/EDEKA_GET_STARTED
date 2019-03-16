package entities.residence;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntityResidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int residence_id;
}
