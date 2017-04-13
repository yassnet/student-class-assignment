package com.tru.dao;

import com.tru.exception.DaoException;
import com.tru.model.Class;
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
    public void getAll() throws DaoException {
        List<Class> classes = classDao.getAll();

        assertThat(classes, not(IsEmptyCollection.empty()));
        assertThat(classes, hasSize(2));
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws DaoException {
        classDao.save(new Class("INF-01", "Algorithms",
                "Algorithms are the heart of computer science"));

        Assert.assertTrue(classDao.findById("INF-01").isPresent());
    }

    @Test
    @Transactional
    @Rollback
    public void update() throws DaoException {
        classDao.update(new Class("RED-515-V2-P1", "Network Management 2",
                "Provide the student with a well-founded knowledge about network management."));
        Optional<Class> aClass = classDao.findById("RED-515-V2-P1");
        
        Assert.assertTrue(aClass.isPresent());
        Assert.assertEquals("Network Management 2", aClass.get().getTitle());
    }

    @Test
    @Transactional
    @Rollback
    public void remove() throws DaoException {
        classDao.save(new Class("RED-515-V2-P2", "Network Management 2",
                "Network Management Second Part"));
        Optional<Class> aClass = classDao.findById("RED-515-V2-P2");
        Assert.assertTrue(aClass.isPresent());

        classDao.remove("RED-515-V2-P2");

        Assert.assertFalse(classDao.findById("RED-515-V2-P2").isPresent());
    }

    @Test
    public void exists() throws DaoException {
        Assert.assertTrue(classDao.exists("RED-514-V2-P1"));
        Assert.assertTrue(classDao.exists("RED-515-V2-P1"));
        Assert.assertFalse(classDao.exists("RED-515-V2-P2"));
    }

    @Test
    public void findById() throws DaoException {
        Optional<Class> aClass = classDao.findById("RED-515-V2-P1");

        Assert.assertTrue(aClass.isPresent());
        Assert.assertEquals("RED-515-V2-P1", aClass.get().getCode());
        Assert.assertEquals("Provide the student with a well-founded knowledge about network management.",
                aClass.get().getDescription());

        aClass = classDao.findById("invalid_code");

        Assert.assertFalse(aClass.isPresent());
    }

    @Test
    public void findByTitle() throws DaoException {

        List<Class> aClass = classDao.findByTitle("Manage");

        Assert.assertEquals(1, aClass.size());
        Assert.assertEquals("RED-515-V2-P1", aClass.get(0).getCode());
        Assert.assertTrue(aClass.get(0).getDescription().contains("well-founded knowledge"));

        assertThat(aClass, not(IsEmptyCollection.empty()));
        assertThat(aClass, hasSize(1));
        assertThat(aClass, hasItem(classDao.findById("RED-515-V2-P1").get()));
    }

    @Test
    public void findByDescription() throws DaoException {

        List<Class> aClass = classDao.findByDescription("networks in terms of information");

        assertThat(aClass, not(IsEmptyCollection.empty()));
        assertThat(aClass, hasSize(1));
        assertThat(aClass, hasItem(classDao.findById("RED-514-V2-P1").get()));
    }

    @Test
    public void findByKey() throws DaoException {

        List<Class> aClass = classDao.findByKey("security");

        assertThat(aClass, not(IsEmptyCollection.empty()));
        assertThat(aClass, hasSize(1));
        assertThat(aClass, hasItem(classDao.findById("RED-514-V2-P1").get()));
    }
}