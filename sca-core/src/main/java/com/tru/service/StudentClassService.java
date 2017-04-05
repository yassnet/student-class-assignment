package com.tru.service;

import com.tru.model.StudentClass;

import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/3/17.
 */
public interface StudentClassService {

    List<StudentClass> getAll();

    void save(StudentClass studentClass);

    void remove(Integer studentId, String code);

    void removeAll();

    Optional<StudentClass> findById(Integer id, String code);

    List<StudentClass> findByStudent(Integer studentId);

    List<StudentClass> findByClass(String code);
}