package com.tru.service.impl;

import com.tru.dao.ClassDao;
import com.tru.exception.CoreException;
import com.tru.exception.DaoException;
import com.tru.model.Class;
import com.tru.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public class ClassServiceImpl implements ClassService {

    private static final Logger logger = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Autowired
    ClassDao classDao;

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public List<Class> getAll() throws CoreException {
        List<Class> list;
        try {
            list = classDao.getAll();
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }

        return list;
    }

    @Override
    public void save(Class aClass) throws CoreException {
        try {
            classDao.save(aClass);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void update(Class aClass) throws CoreException {
        try {
            classDao.update(aClass);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void remove(String code) throws CoreException {
        try {
            classDao.remove(code);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void removeAll() throws CoreException {
        try {
            classDao.removeAll();
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public boolean exists(String code) throws CoreException {
        boolean exists;
        try {
            exists = classDao.exists(code);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return exists;
    }

    @Override
    public Optional<Class> findById(String code) throws CoreException {
        Optional<Class> aClass;
        try {
            aClass = classDao.findById(code);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return aClass;
    }

    @Override
    public List<Class> findByTitle(String title) throws CoreException {
        List<Class> classes;
        try {
            classes = classDao.findByTitle(title);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return classes;
    }

    @Override
    public List<Class> findByDescription(String description) throws CoreException {
        List<Class> classes;
        try {
            classes = classDao.findByDescription(description);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return classes;
    }

    @Override
    public List<Class> findByKey(String key) throws CoreException {
        List<Class> classes;
        try {
            classes = classDao.findByKey(key);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return classes;
    }
}