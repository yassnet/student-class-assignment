package com.tru.dao;

import com.tru.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/2/17.
 */
public interface StudentDao {

    List<Student> getAll();

    void save(Student student);

    void update(Student student);

    void remove(Integer id);

    void removeAll();

    boolean exists(Student student);

    Optional<Student> findById(Integer id);

    List<Student> findByName(String name);
}