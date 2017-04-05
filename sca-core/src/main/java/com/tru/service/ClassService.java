package com.tru.service;

import com.tru.model.Class;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public interface ClassService {

    List<Class> getAll();

    void save(Class aClass);

    void update(Class aClass);

    void remove(String code);

    void removeAll();

    boolean exists(Class aClass);

    Optional<Class> findById(String code);

    List<Class> findByTitle(String title);

    List<Class> findByDescription(String description);

    List<Class> findByKey(String key);
}