package com.tru.service.impl;

import com.tru.dao.StudentClassDao;
import com.tru.model.StudentClass;
import com.tru.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Created by yassnet on 4/3/17.
 */
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    StudentClassDao studentClassDao;

    public void setStudentClassDao(StudentClassDao studentClassDao) {
        this.studentClassDao = studentClassDao;
    }

    @Override
    public List<StudentClass> getAll() {
        return studentClassDao.getAll();
    }

    @Override
    public void save(StudentClass studentClass) {
        studentClassDao.save(studentClass);
    }

    @Override
    public void remove(Integer studentId, String code) {
        studentClassDao.remove(studentId, code);
    }

    @Override
    public void removeAll() {
        studentClassDao.removeAll();
    }

    @Override
    public Optional<StudentClass> findById(Integer id, String code) {
        return studentClassDao.findById(id, code);
    }

    @Override
    public List<StudentClass> findByStudent(Integer studentId) {
        return studentClassDao.findByStudent(studentId);
    }

    @Override
    public List<StudentClass> findByClass(String code) {
        return studentClassDao.findByClass(code);
    }
}