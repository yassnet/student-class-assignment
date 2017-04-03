package com.tru.dao.impl;

import com.tru.dao.ClassDao;
import com.tru.model.Class;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/2/17.
 */
public class ClassDaoImpl extends BaseDaoImpl implements ClassDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Class> getAll() {
        return sessionFactory.openSession().createQuery("From com.tru.model.Class").list();
    }

    @Override
    public void save(Class aClass) {
        saveObject(aClass);
    }

    @Override
    public void update(Class aClass) {
        updateObject(aClass);
    }

    @Override
    public void remove(String code) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Class aClass;
        try {
            aClass = (Class) session.get(Class.class, code);
            session.delete(aClass);
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
            session.createQuery("delete from com.tru.model.Class").executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
    }

    @Override
    public boolean exists(Class aClass) {
        return findById(aClass.getCode()).isPresent();
    }

    @Override
    public Optional<Class> findById(String code) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Class aClass = null;
        try {
            aClass = (Class) session.get(Class.class, code);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return Optional.ofNullable(aClass);
    }

    @Override
    public List<Class> findByName(String key) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Class> classes = new ArrayList<>();
        String hql = "from com.tru.model.Class where title like :key or description like :key";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("key", "%" + key + "%");
            classes = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
        return classes;
    }
}