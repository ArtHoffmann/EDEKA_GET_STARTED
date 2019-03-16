package entities.user;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

}
