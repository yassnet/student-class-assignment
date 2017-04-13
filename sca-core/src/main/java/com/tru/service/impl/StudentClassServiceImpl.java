package com.tru.service.impl;

import com.tru.dao.StudentClassDao;
import com.tru.exception.CoreException;
import com.tru.exception.DaoException;
import com.tru.model.StudentClass;
import com.tru.model.StudentClassPK;
import com.tru.service.StudentClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public class StudentClassServiceImpl implements StudentClassService {

    private static final Logger logger = LoggerFactory.getLogger(StudentClassServiceImpl.class);

    @Autowired
    StudentClassDao studentClassDao;

    public void setStudentClassDao(StudentClassDao studentClassDao) {
        this.studentClassDao = studentClassDao;
    }

    @Override
    public List<StudentClass> getAll() throws CoreException {
        List<StudentClass> list = new ArrayList<>();
        try {
            list = studentClassDao.getAll();
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }

        return list;
    }

    @Override
    public void save(StudentClass studentClass) throws CoreException {
        try {
            studentClassDao.save(studentClass);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void remove(Integer studentId, String code) throws CoreException {
        try {
            studentClassDao.remove(new StudentClassPK(studentId, code));
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public void removeAll() throws CoreException {
        try {
            studentClassDao.removeAll();
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
    }

    @Override
    public Optional<StudentClass> findById(Integer id, String code) throws CoreException {
        Optional<StudentClass> studentClass = Optional.empty();
        try {
            studentClass = studentClassDao.findById(new StudentClassPK(id, code));
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return studentClass;
    }

    @Override
    public List<StudentClass> findByStudent(Integer studentId) throws CoreException {
        List<StudentClass> studentClasses = new ArrayList<>();
        try {
            studentClasses = studentClassDao.findByStudent(studentId);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return studentClasses;
    }

    @Override
    public List<StudentClass> findByClass(String code) throws CoreException {
        List<StudentClass> studentClasses = new ArrayList<>();
        try {
            studentClasses = studentClassDao.findByClass(code);
        } catch (DaoException e) {
            logger.error("ServiceException: ", e);
            throw new CoreException("Data access problems");
        }
        return studentClasses;
    }
}