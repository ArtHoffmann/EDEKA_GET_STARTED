package jpa.residence;

import entities.residence.ResidenceEntity;
import entities.user.UserEntity;
import jpa.user.GenericDaoJpaImpl;
import jpa.user.JpaUserDao;
import models.residence.Residence;
import models.user.User;

import javax.annotation.Nullable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class JpaResidenceDao extends GenericDaoJpaImpl<ResidenceEntity, Integer> {


    JpaUserDao jpaUserDao;

    public List<ResidenceEntity> findAll(){
        return this.entityManager.createNamedQuery("Residence.findAll", ResidenceEntity.class).getResultList();
    }

    public ResidenceEntity createResidenceWithNewUser(ResidenceEntity residenceEntity) {
        residenceEntity.setNumber(residenceEntity.getNumber());
        residenceEntity.setPlace(residenceEntity.getPlace());
        residenceEntity.setStreet(residenceEntity.getStreet());
        residenceEntity.setUser(residenceEntity.getUser());
        create(residenceEntity);
        return residenceEntity;
    }
    public ResidenceEntity editExistingResidenceForUser(int id, ResidenceEntity res) {
        ResidenceEntity residenceEntity = read(id);
        residenceEntity.setStreet(res.getStreet());
        residenceEntity.setPlace(res.getPlace());
        residenceEntity.setNumber(res.getNumber());
        update(residenceEntity);
        return residenceEntity;
    }
    public ResidenceEntity deleteExistingResidenceForUser(int id) {
        ResidenceEntity residenceEntity = read(id);
        delete(residenceEntity);
        return residenceEntity;
    }

}
