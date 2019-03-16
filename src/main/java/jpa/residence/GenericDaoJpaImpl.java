package jpa.residence;

import dao.GenericDaoInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDaoJpaImpl<T, Id extends Serializable>
        implements GenericDaoInterface<T, Id> {

    protected Class<T> entityClass;


    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDaoJpaImpl() {
        Class obtainedClass = getClass();
        Type genericSuperclass = null;
        for(;;) {
            genericSuperclass = obtainedClass.getGenericSuperclass();
            if(genericSuperclass instanceof ParameterizedType) {
                break;
            }
            obtainedClass = obtainedClass.getSuperclass();
        }
        ParameterizedType genericSuperclass_ = (ParameterizedType) genericSuperclass;
        this.entityClass = ((Class) ((Class) genericSuperclass_.getActualTypeArguments()[0]));
    }

    @Override
    @Transactional
    public T create(T t) {
        this.entityManager.getTransaction().begin();
        if(!entityManager.contains(t)) {
            entityManager.persist(t);
        }
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public T read(Id id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        entityManager.getTransaction().begin();
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
        entityManager.getTransaction().commit();
    }
}
