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
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void findById() {
        Course course = repository.findById(10003L);
        assertEquals("spring-boot in 50 steps",course.getName());
    }
    @Test
    @DirtiesContext
    public void deleteById(){
        repository.deleteById(10003L);
        assertNull(repository.findById(10003L));
    }
    @Test
    public void save(){
        Course course = repository.findById(10003L);
        assertEquals("spring-boot in 50 steps",course.getName());

        course.setName("spring-boot in 50 steps - updated");
        repository.save(course);

        Course course1 = repository.findById(10003L);
        assertEquals("spring-boot in 50 steps - updated",course1.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager(){
        repository.playWithEntityManager();
    }
}
