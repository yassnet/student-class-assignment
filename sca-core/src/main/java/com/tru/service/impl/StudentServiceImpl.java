package com.tru.service.impl;

import com.tru.dao.StudentDao;
import com.tru.model.Student;
import com.tru.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void remove(Integer id) {
        studentDao.remove(id);
    }

    @Override
    public void removeAll() {
        studentDao.removeAll();
    }

    @Override
    public boolean exists(Student student) {
        return studentDao.exists(student);
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentDao.findByFirstName(firstName);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentDao.findByLastName(lastName);
    }

    @Override
    public List<Student> findByKey(String key) {
        return studentDao.findByKey(key);
    }
}