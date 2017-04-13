package com.tru.dao.impl;

import com.tru.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public class BaseDaoImpl<T, PK extends java.io.Serializable> implements BaseDao<T,PK> {

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public BaseDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<T> getAll() {
        return sessionFactory.openSession().createQuery("from " + persistentClass.getCanonicalName()).list();
    }

    public void save(T obj) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (obj != null) {
            try {
                session.save(obj);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            } finally {
                session.close();
            }
        }
    }

    public void update(T obj) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (obj != null) {
            try {
                session.update(obj);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            } finally {
                session.close();
            }
        }
    }

    public void remove(PK id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(session.get(persistentClass, id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void removeAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery("delete from " + persistentClass.getCanonicalName()).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public boolean exists(PK id) {
        return findById(id).isPresent();
    }

    public Optional<T> findById(PK id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T obj = null;
        try {
            obj = (T) session.get(persistentClass, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        
        return Optional.ofNullable(obj);
    }
}