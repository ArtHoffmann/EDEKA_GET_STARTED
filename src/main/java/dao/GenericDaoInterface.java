package dao;

import javax.transaction.Transactional;
import java.io.Serializable;

public interface GenericDaoInterface<T, Id extends Serializable> {

    T create(T t);
    T read(Id id);
    T update(T t);
    void delete(T t);
}