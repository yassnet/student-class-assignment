package com.tru.service;

import com.tru.model.Class;

import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/3/17.
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