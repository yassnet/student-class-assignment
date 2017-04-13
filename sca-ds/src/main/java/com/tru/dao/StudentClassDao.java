package com.tru.dao;

import com.tru.model.StudentClass;
import com.tru.model.StudentClassPK;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public interface StudentClassDao extends BaseDao<StudentClass, StudentClassPK> {

    List<StudentClass> findByStudent(Integer studentId);

    List<StudentClass> findByClass(String code);
}