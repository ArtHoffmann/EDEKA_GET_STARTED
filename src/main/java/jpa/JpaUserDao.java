package jpa;

import entities.User;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class JpaUserDao extends GenericDaoJpaImpl<User, Integer> {

    public List<User> findAll(){
    return this.entityManager.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User createANewOne(User object){
        this.entityManager.persist(object);
        return object;
    }

    public User specificUser(int id) {
        return this.entityManager.createQuery("Select u FROM User u Where u.id =" +id, User.class).getSingleResult();
    }
}
