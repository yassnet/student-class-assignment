package com.tru.dao;

import com.tru.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/11/17.
 */
public interface BaseDao <T, PK extends java.io.Serializable> {

    List<T> getAll() throws DaoException;

    void save(T aClass) throws DaoException;

    void update(T aClass) throws DaoException;

    void remove(PK id) throws DaoException;

    void removeAll() throws DaoException;

    boolean exists(PK id) throws DaoException;

    Optional<T> findById(PK id) throws DaoException;
}
