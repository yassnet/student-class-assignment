package com.tru.service.impl;

import com.tru.dao.ClassDao;
import com.tru.model.Class;
import com.tru.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDao classDao;

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public List<Class> getAll() {
        return classDao.getAll();
    }

    @Override
    public void save(Class aClass) {
        classDao.save(aClass);
    }

    @Override
    public void update(Class aClass) {
        classDao.update(aClass);
    }

    @Override
    public void remove(String code) {
        classDao.remove(code);
    }

    @Override
    public void removeAll() {
        classDao.removeAll();
    }

    @Override
    public boolean exists(Class aClass) {
        return classDao.exists(aClass);
    }

    @Override
    public Optional<Class> findById(String code) {
        return classDao.findById(code);
    }

    @Override
    public List<Class> findByTitle(String title) {
        return classDao.findByTitle(title);
    }

    @Override
    public List<Class> findByDescription(String description) {
        return classDao.findByDescription(description);
    }

    @Override
    public List<Class> findByKey(String key) {
        return classDao.findByKey(key);
    }
}