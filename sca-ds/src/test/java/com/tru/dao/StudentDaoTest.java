package com.tru.dao;

import com.tru.exception.DaoException;
import com.tru.model.Student;
import org.hamcrest.collection.IsEmptyCollection;
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

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
@ContextConfiguration(locations = "classpath:db-derby-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void getAll() throws DaoException {
        List<Student> students = studentDao.getAll();

        assertThat(students, not(IsEmptyCollection.empty()));
        assertThat(students, hasSize(2));
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws DaoException {
        studentDao.save(new Student(null, "Johny", "Vasquez"));

        System.out.println("studentDao.getAll(): [" + studentDao.getAll() + "]");;

        assertThat(studentDao.findByLastName("Vasquez"), hasSize(1));
    }

    @Test
    @Transactional
    @Rollback
    public void update() throws DaoException {
        studentDao.update(new Student(1, "Yassir", "Aguila Magne"));
        Optional<Student> student = studentDao.findById(1);
        Assert.assertTrue(student.isPresent());
        Assert.assertEquals("Aguila Magne", student.get().getLastName());
    }

    @Test
    @Transactional
    @Rollback
    public void remove() throws DaoException {
        studentDao.save(new Student(null, "Johnny", "Ramirez"));
        List<Student> student = studentDao.findByLastName("Ramirez");
        Assert.assertEquals(1, student.size());

        studentDao.remove(student.get(0).getId());

        Assert.assertFalse(studentDao.findById(student.get(0).getId()).isPresent());
    }

    @Test
    public void exists() throws DaoException {
        Assert.assertTrue(studentDao.exists(1));
        Assert.assertTrue(studentDao.exists(2));
        Assert.assertFalse(studentDao.exists(3));
    }

    @Test
    public void findById() throws DaoException {
        Optional<Student> student = studentDao.findById(1);

        Assert.assertTrue(student.isPresent());
        assertThat(student.get(), is(studentDao.findByFirstName("Yassir").get(0)));

        student = studentDao.findById(4);

        Assert.assertFalse(student.isPresent());
    }

    @Test
    public void findByFirstName() throws DaoException {

        List<Student> student = studentDao.findByFirstName("Wilfredo");

        assertThat(student, not(IsEmptyCollection.empty()));
        assertThat(student, hasSize(1));
        assertThat(student, hasItem(studentDao.findById(2).get()));
    }

    @Test
    public void findByLastName() throws DaoException {

        List<Student> student = studentDao.findByLastName("Aguila");

        assertThat(student, not(IsEmptyCollection.empty()));
        assertThat(student, hasSize(2));
        assertThat(student, hasItem(studentDao.findById(1).get()));
        assertThat(student, hasItem(studentDao.findById(2).get()));
    }

    @Test
    public void findByKey() throws DaoException {

        List<Student> student = studentDao.findByKey("Yass");

        assertThat(student, not(IsEmptyCollection.empty()));
        assertThat(student, hasSize(1));
        assertThat(student, hasItem(studentDao.findById(1).get()));
    }
}