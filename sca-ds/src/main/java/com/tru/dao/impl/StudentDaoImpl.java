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
 * Created by yassnet on 4/2/17.
 */
public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() {
        return sessionFactory.openSession().createQuery("From com.tru.model.Student").list();
    }

    @Override
    public void save(Student student) {
        saveObject(student);
    }

    @Override
    public void update(Student student) {
        updateObject(student);
    }

    @Override
    public void remove(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student;
        try {
            student = (Student) session.get(Student.class, id);
            session.delete(student);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }

    @Override
    public void removeAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery("delete from com.tru.model.Student").executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }

    @Override
    public boolean exists(Student student) {
        return findById(student.getId()).isPresent();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = null;
        try {
            student = (Student) session.get(Student.class, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return Optional.ofNullable(student);
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
            session.close();
        } catch (Exception e) {
            transaction.rollback();
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
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return students;
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
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return students;
    }
}