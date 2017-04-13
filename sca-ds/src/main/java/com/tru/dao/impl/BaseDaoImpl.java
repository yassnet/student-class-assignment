package com.tru.dao.impl;

import com.tru.dao.BaseDao;
import com.tru.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public class BaseDaoImpl<T, PK extends java.io.Serializable> implements BaseDao<T, PK> {

    private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public BaseDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<T> getAll() throws DaoException {
        List<T> list;
        try {
            list = sessionFactory.openSession().createQuery("from " + persistentClass.getCanonicalName()).list();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        }
        return list;
    }

    public void save(T obj) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (obj != null) {
            try {
                session.save(obj);
                transaction.commit();
            } catch (Exception e) {
                logger.error("DaoException: ", e);
                transaction.rollback();
                throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
            } finally {
                session.close();
            }
        }
    }

    public void update(T obj) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (obj != null) {
            try {
                session.update(obj);
                transaction.commit();
            } catch (Exception e) {
                logger.error("DaoException: ", e);
                transaction.rollback();
                throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
            } finally {
                session.close();
            }
        }
    }

    public void remove(PK id) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(session.get(persistentClass, id));
            transaction.commit();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            transaction.rollback();
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        } finally {
            session.close();
        }
    }

    public void removeAll() throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery("delete from " + persistentClass.getCanonicalName()).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            transaction.rollback();
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        } finally {
            session.close();
        }
    }

    public boolean exists(PK id) throws DaoException {
        return findById(id).isPresent();
    }

    public Optional<T> findById(PK id) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T obj;
        try {
            obj = (T) session.get(persistentClass, id);
            transaction.commit();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            transaction.rollback();
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        } finally {
            session.close();
        }

        return Optional.ofNullable(obj);
    }

    public List<T> findByKey(String key, String hql) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<T> classes;
        try {
            Query query = session.createQuery(hql);
            query.setParameter("key", "%" + key + "%");
            classes = query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error("DaoException: ", e);
            transaction.rollback();
            throw new DaoException(e.getMessage(), e.getCause() != null ? e.getCause().getMessage() : null);
        } finally {
            session.close();
        }
        return classes;
    }
}