package com.tru.dao;

import com.tru.model.StudentClass;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
public interface StudentClassDao {

    List<StudentClass> getAll();

    void save(StudentClass studentClass);

    void remove(Integer studentId, String code);

    void removeAll();

    Optional<StudentClass> findById(Integer id, String code);

    List<StudentClass> findByStudent(Integer studentId);

    List<StudentClass> findByClass(String code);
}