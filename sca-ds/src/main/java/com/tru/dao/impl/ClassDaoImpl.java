package com.tru.dao.impl;

import com.tru.dao.ClassDao;
import com.tru.exception.DaoException;
import com.tru.model.Class;
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
public class ClassDaoImpl extends BaseDaoImpl<Class, String> implements ClassDao {

    private static final Logger logger = LoggerFactory.getLogger(ClassDaoImpl.class);

    public ClassDaoImpl() {
        super(Class.class);
    }

    @Override
    public List<Class> findByKey(String key) throws DaoException {
        return findByKey(key, "from com.tru.model.Class where code like :key or title like :key or description like :key");
    }

    @Override
    public List<Class> findByTitle(String title) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Class> classes;
        String hql = "from com.tru.model.Class where title like :title";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("title", "%" + title + "%");
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

    @Override
    public List<Class> findByDescription(String description) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Class> classes;
        String hql = "from com.tru.model.Class where description like :description";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("description", "%" + description + "%");
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