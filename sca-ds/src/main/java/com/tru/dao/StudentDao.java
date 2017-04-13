package com.tru.dao;

import com.tru.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public interface StudentDao extends BaseDao<Student, Integer> {

    List<Student> findByKey(String key);

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);
}