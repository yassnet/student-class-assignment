package com.tru.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public class BaseDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    void saveObject(Object obj) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (obj != null) {
            try {
                session.save(obj);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                session.close();
            }
        }
    }

    void updateObject(Object obj) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (obj != null) {
            try {
                session.update(obj);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                session.close();
            }
        }
    }
}