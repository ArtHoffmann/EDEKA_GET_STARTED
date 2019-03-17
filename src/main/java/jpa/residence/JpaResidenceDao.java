package jpa.residence;

import entities.residence.ResidenceEntity;
import entities.user.UserEntity;
import jpa.user.GenericDaoJpaImpl;
import models.residence.Residence;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class JpaResidenceDao extends GenericDaoJpaImpl<ResidenceEntity, Integer> {

    public List<ResidenceEntity> findAll(){
        return this.entityManager.createNamedQuery("Residence.findAll", ResidenceEntity.class).getResultList();
    }
}
