package com.tru.service;

import com.tru.exception.CoreException;
import com.tru.model.Class;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public interface ClassService {

    List<Class> getAll() throws CoreException;

    void save(Class aClass) throws CoreException;

    void update(Class aClass) throws CoreException;

    void remove(String code) throws CoreException;

    void removeAll() throws CoreException;

    boolean exists(String code) throws CoreException;

    Optional<Class> findById(String code) throws CoreException;

    List<Class> findByTitle(String title) throws CoreException;

    List<Class> findByDescription(String description) throws CoreException;

    List<Class> findByKey(String key) throws CoreException;
}