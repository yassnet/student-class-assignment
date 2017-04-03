package com.tru.dao.impl;

import com.tru.dao.StudentClassDao;
import com.tru.model.StudentClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/2/17.
 */
public class StudentClassDaoImpl extends BaseDaoImpl implements StudentClassDao {

    @Override
    public List<StudentClass> getAll() {
        return sessionFactory.openSession().createQuery("From com.tru.model.StudentClass").list();
    }

    @Override
    public void save(StudentClass studentClass) {
        saveObject(studentClass);
    }

    @Override
    public void remove(Integer studentId, String code) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Optional<StudentClass> studentClass;
        try {
            studentClass = findById(studentId, code);
            if (studentClass.isPresent()) {
                session.delete(studentClass.get());
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
    }

    @Override
    public void removeAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery("delete from com.tru.model.StudentClass").executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }

    @Override
    public Optional<StudentClass> findById(Integer studentId, String code) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentClass studentClass = null;
        String hql = "from com.tru.model.StudentClass where student.id = :id and aClass.code = :code";
        try {
            Query query = session.createQuery(hql);
            query.setInteger("id", studentId);
            query.setString("code", code);
            studentClass = (StudentClass) query.uniqueResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return Optional.ofNullable(studentClass);
    }

    @Override
    public List<StudentClass> findByStudent(Integer studentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentClass> studentClasses = new ArrayList<>();
        String hql = "from com.tru.model.StudentClass where student.id = :id";
        try {
            Query query = session.createQuery(hql);
            query.setInteger("id", studentId);
            studentClasses = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return studentClasses;
    }

    @Override
    public List<StudentClass> findByClass(String code) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentClass> studentClasses = new ArrayList<>();
        String hql = "from com.tru.model.StudentClass where aClass.code = :code";
        try {
            Query query = session.createQuery(hql);
            query.setString("code", code);
            studentClasses = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return studentClasses;
    }
}