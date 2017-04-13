package com.tru.dao;

import com.tru.model.Class;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public interface ClassDao extends BaseDao<Class, String> {

    List<Class> findByKey(String key);

    List<Class> findByTitle(String title);

    List<Class> findByDescription(String description);
}