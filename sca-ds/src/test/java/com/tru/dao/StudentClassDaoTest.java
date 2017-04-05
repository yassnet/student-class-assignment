package com.tru.dao;

import com.tru.model.Class;
import com.tru.model.Student;
import com.tru.model.StudentClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
@ContextConfiguration(locations = "classpath:db-derby-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class StudentClassDaoTest {

    @Autowired
    StudentClassDao studentClassDao;

    @Test
    public void getAll() throws Exception {
        List<StudentClass> studentClasses = studentClassDao.getAll();

        Assert.assertEquals(2, studentClasses.size());
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        studentClassDao.save(new StudentClass(new Student(1, null, null),
                new Class("RED-515-V2-P1", null,
                        null)));

        Assert.assertTrue(studentClassDao.findById(1, "RED-515-V2-P1").isPresent());

        studentClassDao.remove(1, "RED-515-V2-P1");
    }

    @Test
    @Transactional
    @Rollback
    public void remove() throws Exception {
        studentClassDao.save(new StudentClass(new Student(1, null, null),
                        new Class("RED-515-V2-P1", null,
                                null)));

        studentClassDao.remove(1, "RED-515-V2-P1");
        Assert.assertFalse(studentClassDao.findById(1, "RED-515-V2-P1").isPresent());
    }

    @Test
    public void findById() throws Exception {
        Optional<StudentClass> studentClass = studentClassDao.findById(2, "RED-514-V2-P1");

        Assert.assertTrue(studentClass.isPresent());
        Assert.assertEquals("RED-514-V2-P1", studentClass.get().getaClass().getCode());
        Assert.assertEquals("Wilfredo", studentClass.get().getStudent().getFirstName());
        Assert.assertEquals("Provide to student the ability to manage networks in terms of information security.",
                studentClass.get().getaClass().getDescription());

        studentClass = studentClassDao.findById(1, "invalid_code");

        Assert.assertFalse(studentClass.isPresent());
    }

    @Test
    public void findByStudent() throws Exception {
        List<StudentClass> studentClasses = studentClassDao.findByStudent(2);

        Assert.assertEquals(1, studentClasses.size());
        Assert.assertEquals("RED-514-V2-P1", studentClasses.get(0).getaClass().getCode());
        Assert.assertEquals("Network Security", studentClasses.get(0).getaClass().getTitle());
        Assert.assertTrue(studentClasses.get(0).getaClass().getDescription().contains("information security"));
    }

    @Test
    public void findByClass() throws Exception {
        List<StudentClass> studentClasses = studentClassDao.findByClass("RED-514-V2-P1");

        Assert.assertEquals(2, studentClasses.size());
        Assert.assertEquals(1, studentClasses.get(0).getStudent().getId().intValue());
        Assert.assertEquals("Yassir", studentClasses.get(0).getStudent().getFirstName());
        Assert.assertEquals("Aguila", studentClasses.get(0).getStudent().getLastName());
    }
}