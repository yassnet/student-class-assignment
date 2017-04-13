package com.tru.dao;

import com.tru.exception.DaoException;
import com.tru.model.Class;

import java.util.List;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public interface ClassDao extends BaseDao<Class, String> {

    List<Class> findByKey(String key) throws DaoException;

    List<Class> findByTitle(String title) throws DaoException;

    List<Class> findByDescription(String description) throws DaoException;
}