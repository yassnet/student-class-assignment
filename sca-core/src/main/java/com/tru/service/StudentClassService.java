package com.tru.service;

import com.tru.exception.CoreException;
import com.tru.model.StudentClass;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public interface StudentClassService {

    List<StudentClass> getAll() throws CoreException;

    void save(StudentClass studentClass) throws CoreException;

    void remove(Integer studentId, String code) throws CoreException;

    void removeAll() throws CoreException;

    Optional<StudentClass> findById(Integer id, String code) throws CoreException;

    List<StudentClass> findByStudent(Integer studentId) throws CoreException;

    List<StudentClass> findByClass(String code) throws CoreException;
}