package com.vj.jpa.hibernate.jpademo.repository;

import com.vj.jpa.hibernate.jpademo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        if (course.getId()==null){
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        Course course1 = new Course("web service in 100 steps");
        entityManager.persist(course1);


        Course course2 = new Course("Angular JS in 100 steps");
        entityManager.persist(course2);
        //entityManager.detach(course2);
        entityManager.flush();

        //entityManager.clear();

        course1.setName("web service in 100 steps updated");
        entityManager.flush();

        course2.setName("Angular JS in 100 steps updated");
        //entityManager.flush();

        entityManager.refresh(course2);

        logger.info("PlayWithEntityManager -starts");
    }
}
