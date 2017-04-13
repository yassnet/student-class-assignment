package com.tru.dao.impl;

import com.tru.dao.StudentDao;
import com.tru.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public class StudentDaoImpl extends BaseDaoImpl<Student, Integer> implements StudentDao {

    public StudentDaoImpl() {
        super(Student.class);
    }

    @Override
    public List<Student> findByKey(String key) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = new ArrayList<>();
        String hql = "from com.tru.model.Student where firstName like :key or lastName like :key";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("key", "%" + key + "%");
            students = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return students;
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = new ArrayList<>();
        String hql = "from com.tru.model.Student where firstName like :firstName";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("firstName", "%" + firstName + "%");
            students = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return students;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = new ArrayList<>();
        String hql = "from com.tru.model.Student where lastName like :lastName";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("lastName", "%" + lastName + "%");
            students = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return students;
    }
}