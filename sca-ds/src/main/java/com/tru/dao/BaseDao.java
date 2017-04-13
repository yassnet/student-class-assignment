package com.tru.dao;

import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/11/17.
 */
public interface BaseDao <T, PK extends java.io.Serializable> {

    List<T> getAll();

    void save(T aClass);

    void update(T aClass);

    void remove(PK id);

    void removeAll();

    boolean exists(PK id);

    Optional<T> findById(PK id);
}
