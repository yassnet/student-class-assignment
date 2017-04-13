package com.tru.service.impl;

import com.tru.dao.StudentDao;
import com.tru.exception.CoreException;
import com.tru.exception.DaoException;
import com.tru.model.Student;
import com.tru.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAll() throws CoreException {
        List<Student> list;
        try {
            list = studentDao.getAll();
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }

        return list;
    }

    @Override
    public void save(Student student) throws CoreException {
        try {
            studentDao.save(student);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void update(Student student) throws CoreException {
        try {
            studentDao.update(student);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void remove(Integer id) throws CoreException {
        try {
            studentDao.remove(id);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void removeAll() throws CoreException {
        try {
            studentDao.removeAll();
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public boolean exists(Integer id) throws CoreException {
        boolean exists;
        try {
            exists = studentDao.exists(id);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return exists;
    }

    @Override
    public Optional<Student> findById(Integer id) throws CoreException {
        Optional<Student> student;
        try {
            student = studentDao.findById(id);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return student;
    }

    @Override
    public List<Student> findByFirstName(String firstName) throws CoreException {
        List<Student> students;
        try {
            students = studentDao.findByFirstName(firstName);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return students;
    }

    @Override
    public List<Student> findByLastName(String lastName) throws CoreException {
        List<Student> students;
        try {
            students = studentDao.findByLastName(lastName);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return students;
    }

    @Override
    public List<Student> findByKey(String key) throws CoreException {
        List<Student> students;
        try {
            students = studentDao.findByKey(key);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return students;
    }
}