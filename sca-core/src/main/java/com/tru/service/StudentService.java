package com.tru.service;

import com.tru.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public interface StudentService {

    List<Student> getAll();

    void save(Student student);

    void update(Student student);

    void remove(Integer id);

    void removeAll();

    boolean exists(Student student);

    Optional<Student> findById(Integer id);

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByKey(String key);
}