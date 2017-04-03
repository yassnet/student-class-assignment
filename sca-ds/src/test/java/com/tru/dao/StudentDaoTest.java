package com.tru.dao;

import com.tru.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@ContextConfiguration(locations = "classpath:db-derby-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void getAll() throws Exception {
        List<Student> students = studentDao.getAll();

        Assert.assertEquals(2, students.size());
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        studentDao.save(new Student(null, "Johny", "Vasquez"));

        Assert.assertEquals(1, studentDao.findByLastName("Vasquez").size());
    }

    @Test
    @Transactional
    @Rollback
    public void update() throws Exception {
        studentDao.update(new Student(1, "Yassir", "Aguila Magne"));
        Optional<Student> student = studentDao.findById(1);
        Assert.assertTrue(student.isPresent());
        Assert.assertEquals("Aguila Magne", student.get().getLastName());
    }

    @Test
    @Transactional
    @Rollback
    public void remove() throws Exception {
        studentDao.save(new Student(3, "Johnny", "Vasquez"));
        List<Student> student = studentDao.findByFirstName("Johnny");
        Assert.assertEquals(1, student.size());

        studentDao.remove(student.get(0).getId());

        Assert.assertFalse(studentDao.findById(student.get(0).getId()).isPresent());
    }

    @Test
    public void exists() throws Exception {
        Assert.assertTrue(studentDao.exists(new Student(1, "Yassir", "Aguila")));
        Assert.assertTrue(studentDao.exists(new Student(2, null, null)));
        Assert.assertFalse(studentDao.exists(new Student(3, "Yassir", "Aguila")));
    }

    @Test
    public void findById() throws Exception {
        Optional<Student> student = studentDao.findById(1);

        Assert.assertTrue(student.isPresent());
        Assert.assertEquals(1, student.get().getId().intValue());
        Assert.assertEquals("Yassir", student.get().getFirstName());

        student = studentDao.findById(3);

        Assert.assertFalse(student.isPresent());
    }

    @Test
    public void findByFirstName() {

        List<Student> student = studentDao.findByFirstName("Wilfredo");

        Assert.assertEquals(1, student.size());
        Assert.assertEquals(2, student.get(0).getId().intValue());
        Assert.assertEquals("Wilfredo", student.get(0).getFirstName());
        Assert.assertEquals("Aguila", student.get(0).getLastName());
    }

    @Test
    public void findByLastName() {

        List<Student> student = studentDao.findByLastName("Aguila");

        Assert.assertEquals(2, student.size());
        Assert.assertEquals(1, student.get(0).getId().intValue());
        Assert.assertEquals("Yassir", student.get(0).getFirstName());
        Assert.assertEquals("Wilfredo", student.get(1).getFirstName());
    }

    @Test
    public void findByKey() {

        List<Student> student = studentDao.findByKey("Yass");

        Assert.assertEquals(1, student.size());
        Assert.assertEquals(1, student.get(0).getId().intValue());
        Assert.assertEquals("Yassir", student.get(0).getFirstName());
    }
}