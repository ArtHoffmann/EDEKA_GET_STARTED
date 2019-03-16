package jpa.user;

import entities.user.UserEntity;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class JpaUserDao extends GenericDaoJpaImpl<UserEntity, Integer> {

    public List<UserEntity> findAll(){
    return this.entityManager.createNamedQuery("User.findAll", UserEntity.class).getResultList();
    }

    public UserEntity createANewOne(UserEntity object){
        this.entityManager.persist(object);
        return object;
    }

    public UserEntity specificUser(int id) {
        return this.entityManager.createQuery("Select u FROM UserEntity u Where u.id =" +id, UserEntity.class).getSingleResult();
    }
}
