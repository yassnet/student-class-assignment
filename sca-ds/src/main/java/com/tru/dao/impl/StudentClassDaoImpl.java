package com.tru.dao.impl;

import com.tru.dao.StudentClassDao;
import com.tru.model.StudentClass;
import com.tru.model.StudentClassPK;
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
public class StudentClassDaoImpl extends BaseDaoImpl<StudentClass, StudentClassPK> implements StudentClassDao {

    public StudentClassDaoImpl() {
        super(StudentClass.class);
    }

    @Override
    public List<StudentClass> findByStudent(Integer studentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentClass> studentClasses = new ArrayList<>();
        String hql = "from com.tru.model.StudentClass where studentClassPK.student.id = :id";
        try {
            Query query = session.createQuery(hql);
            query.setInteger("id", studentId);
            studentClasses = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return studentClasses;
    }

    @Override
    public List<StudentClass> findByClass(String code) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentClass> studentClasses = new ArrayList<>();
        String hql = "from com.tru.model.StudentClass where studentClassPK.aClass.code = :code";
        try {
            Query query = session.createQuery(hql);
            query.setString("code", code);
            studentClasses = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return studentClasses;
    }
}