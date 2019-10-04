package com.vj.jpa.hibernate.jpademo;

import com.vj.jpa.hibernate.jpademo.entity.Course;
import com.vj.jpa.hibernate.jpademo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Course course = courseRepository.findById(10001L);
		logger.info("find by id 10001 -> {} "+course);
		courseRepository.deleteById(10001L);
		courseRepository.save(new Course("ms in 100 steps"));*/

		courseRepository.playWithEntityManager();
	}
}
