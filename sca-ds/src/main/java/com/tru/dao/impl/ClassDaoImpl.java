package com.tru.dao.impl;

import com.tru.dao.ClassDao;
import com.tru.model.Class;
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
public class ClassDaoImpl extends BaseDaoImpl<Class, String> implements ClassDao {

    public ClassDaoImpl() {
        super(Class.class);
    }

    @Override
    public List<Class> findByKey(String key) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Class> classes = new ArrayList<>();
        String hql = "from com.tru.model.Class where code like :key or title like :key or description like :key";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("key", "%" + key + "%");
            classes = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return classes;
    }

    @Override
    public List<Class> findByTitle(String title) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Class> classes = new ArrayList<>();
        String hql = "from com.tru.model.Class where title like :title";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("title", "%" + title + "%");
            classes = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return classes;
    }

    @Override
    public List<Class> findByDescription(String description) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Class> classes = new ArrayList<>();
        String hql = "from com.tru.model.Class where description like :description";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("description", "%" + description + "%");
            classes = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return classes;
    }
}