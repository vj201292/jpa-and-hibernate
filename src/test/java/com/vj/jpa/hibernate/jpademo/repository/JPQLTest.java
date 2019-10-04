package com.vj.jpa.hibernate.jpademo.repository;

import com.vj.jpa.hibernate.jpademo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void findById() {
        List resultList = entityManager.createQuery("select c from Course c").getResultList();
        logger.info("resultlist -> {}"+resultList);
    }

    @Test
    public void findByIdByType() {
        TypedQuery<Course> typedList = entityManager.createQuery("select c from Course c", Course.class);
        List<Course> resultList = typedList.getResultList();
        logger.info("resultlist -> {}"+resultList);
    }
}