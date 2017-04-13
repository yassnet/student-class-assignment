package com.tru.dao.impl;

import com.tru.dao.StudentDao;
import com.tru.exception.DaoException;
import com.tru.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public class StudentDaoImpl extends BaseDaoImpl<Student, Integer> implements StudentDao {

    private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

    public StudentDaoImpl() {
        super(Student.class);
    }

    @Override
    public List<Student> findByKey(String key) throws DaoException {
        return findByKey(key, "from com.tru.model.Student where firstName like :key or lastName like :key");
    }

    @Override
    public List<Student> findByFirstName(String firstName) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students;
        String hql = "from com.tru.model.Student where firstName like :firstName";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("firstName", "%" + firstName + "%");
            students = query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            transaction.rollback();
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        } finally {
            session.close();
        }
        return students;
    }

    @Override
    public List<Student> findByLastName(String lastName) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students;
        String hql = "from com.tru.model.Student where lastName like :lastName";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("lastName", "%" + lastName + "%");
            students = query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            transaction.rollback();
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        } finally {
            session.close();
        }
        return students;
    }
}