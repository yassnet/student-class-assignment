package com.tru.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yassnet on 4/2/17.
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