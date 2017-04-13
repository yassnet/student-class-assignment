package com.tru.dao;

import com.tru.model.StudentClass;
import com.tru.model.StudentClassPK;
import org.hamcrest.collection.IsEmptyCollection;
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

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

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

        assertThat(studentClasses, not(IsEmptyCollection.empty()));
        assertThat(studentClasses, hasSize(2));
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        studentClassDao.save(new StudentClass(new StudentClassPK(1, "RED-515-V2-P1")));

        Assert.assertTrue(studentClassDao.findById(new StudentClassPK(1, "RED-515-V2-P1")).isPresent());

        studentClassDao.remove(new StudentClassPK(1, "RED-515-V2-P1"));
    }

    @Test
    @Transactional
    @Rollback
    public void remove() throws Exception {
        studentClassDao.save(new StudentClass(new StudentClassPK(1,"RED-515-V2-P1")));

        studentClassDao.remove(new StudentClassPK(1, "RED-515-V2-P1"));
        Assert.assertFalse(studentClassDao.findById(new StudentClassPK(1, "RED-515-V2-P1")).isPresent());
    }

    @Test
    public void findById() throws Exception {
        Optional<StudentClass> studentClass = studentClassDao.findById(new StudentClassPK(2, "RED-514-V2-P1"));

        Assert.assertTrue(studentClass.isPresent());
        Assert.assertEquals("RED-514-V2-P1", studentClass.get().getStudentClassPK().getaClass().getCode());
        
        studentClass = studentClassDao.findById(new StudentClassPK(1, "RED-515-V2-P1"));

        Assert.assertFalse(studentClass.isPresent());
    }

    @Test
    public void findByStudent() throws Exception {
        List<StudentClass> studentClasses = studentClassDao.findByStudent(2);

        assertThat(studentClasses, not(IsEmptyCollection.empty()));
        assertThat(studentClasses, hasSize(1));
        Assert.assertEquals(new StudentClassPK(2, "RED-514-V2-P1"), studentClasses.get(0).getStudentClassPK());
    }

    @Test
    public void findByClass() throws Exception {
        List<StudentClass> studentClasses = studentClassDao.findByClass("RED-514-V2-P1");

        assertThat(studentClasses, not(IsEmptyCollection.empty()));
        assertThat(studentClasses, hasSize(2));
        Assert.assertEquals(new StudentClassPK(1, "RED-514-V2-P1"), studentClasses.get(0).getStudentClassPK());
        Assert.assertEquals(new StudentClassPK(2, "RED-514-V2-P1"), studentClasses.get(1).getStudentClassPK());
    }
}