package com.tru.service;

import com.tru.exception.CoreException;
import com.tru.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public interface StudentService {

    List<Student> getAll() throws CoreException;

    void save(Student student) throws CoreException;

    void update(Student student) throws CoreException;

    void remove(Integer id) throws CoreException;

    void removeAll() throws CoreException;

    boolean exists(Integer id) throws CoreException;

    Optional<Student> findById(Integer id) throws CoreException;

    List<Student> findByFirstName(String firstName) throws CoreException;

    List<Student> findByLastName(String lastName) throws CoreException;

    List<Student> findByKey(String key) throws CoreException;
}