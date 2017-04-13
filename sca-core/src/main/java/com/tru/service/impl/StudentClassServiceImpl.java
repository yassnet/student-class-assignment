package com.tru.service.impl;

import com.tru.dao.StudentClassDao;
import com.tru.model.StudentClass;
import com.tru.model.StudentClassPK;
import com.tru.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
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
        studentClassDao.remove(new StudentClassPK(studentId, code));
    }

    @Override
    public void removeAll() {
        studentClassDao.removeAll();
    }

    @Override
    public Optional<StudentClass> findById(Integer id, String code) {
        return studentClassDao.findById(new StudentClassPK(id, code));
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