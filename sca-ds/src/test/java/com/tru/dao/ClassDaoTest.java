package com.tru.dao;

import com.tru.model.Class;
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

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
@ContextConfiguration(locations = "classpath:db-derby-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClassDaoTest {

    @Autowired
    ClassDao classDao;

    @Test
    public void getAll() throws Exception {
        List<Class> students = classDao.getAll();

        Assert.assertEquals(2, students.size());
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        classDao.save(new Class("INF-01", "Algorithms",
                "Algorithms are the heart of computer science"));

        Assert.assertTrue(classDao.findById("INF-01").isPresent());
    }

    @Test
    @Transactional
    @Rollback
    public void update() throws Exception {
        classDao.update(new Class("RED-515-V2-P1", "Network Management 2",
                "Provide the student with a well-founded knowledge about network management."));
        Optional<Class> aClass = classDao.findById("RED-515-V2-P1");
        Assert.assertTrue(aClass.isPresent());
        Assert.assertEquals("Network Management 2", aClass.get().getTitle());
    }

    @Test
    @Transactional
    @Rollback
    public void remove() throws Exception {
        classDao.save(new Class("RED-515-V2-P2", "Network Management 2",
                "Network Management Second Part"));
        Optional<Class> aClass = classDao.findById("RED-515-V2-P2");
        Assert.assertTrue(aClass.isPresent());

        classDao.remove("RED-515-V2-P2");

        Assert.assertFalse(classDao.findById("RED-515-V2-P2").isPresent());
    }

    @Test
    public void exists() throws Exception {
        Assert.assertTrue(classDao.exists(new Class("RED-514-V2-P1", "Network Security",
                "Provide to student the ability to manage networks in terms of information security.")));
        Assert.assertTrue(classDao.exists(new Class("RED-515-V2-P1", null, null)));
        Assert.assertFalse(classDao.exists(new Class("RED-515-V2-P2", "Yassir", "Aguila")));
    }

    @Test
    public void findById() throws Exception {
        Optional<Class> aClass = classDao.findById("RED-515-V2-P1");

        Assert.assertTrue(aClass.isPresent());
        Assert.assertEquals("RED-515-V2-P1", aClass.get().getCode());
        Assert.assertEquals("Provide the student with a well-founded knowledge about network management.",
                aClass.get().getDescription());

        aClass = classDao.findById("invalid_code");

        Assert.assertFalse(aClass.isPresent());
    }

    @Test
    public void findByTitle() {

        List<Class> aClass = classDao.findByTitle("Manage");

        Assert.assertEquals(1, aClass.size());
        Assert.assertEquals("RED-515-V2-P1", aClass.get(0).getCode());
        Assert.assertTrue(aClass.get(0).getDescription().contains("well-founded knowledge"));
    }

    @Test
    public void findByDescription() {

        List<Class> aClass = classDao.findByDescription("networks in terms of information");

        Assert.assertEquals(1, aClass.size());
        Assert.assertEquals("RED-514-V2-P1", aClass.get(0).getCode());
        Assert.assertEquals("Network Security", aClass.get(0).getTitle());
        Assert.assertTrue(aClass.get(0).getDescription().contains("security"));
    }

    @Test
    public void findByKey() {

        List<Class> aClass = classDao.findByKey("security");

        Assert.assertEquals(1, aClass.size());
        Assert.assertEquals("RED-514-V2-P1", aClass.get(0).getCode());
        Assert.assertEquals("Network Security", aClass.get(0).getTitle());
        Assert.assertTrue(aClass.get(0).getDescription().contains("information security"));
    }
}