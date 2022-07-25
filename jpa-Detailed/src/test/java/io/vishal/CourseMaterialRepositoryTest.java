package io.vishal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.vishal.entity.Course;
import io.vishal.entity.CourseMaterial;
import io.vishal.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRespository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
				.courseTitle("webdev")
				.credit(2)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.web2dev.com")
				.course(course)
				.build();
		
		courseMaterialRespository.save(courseMaterial);
	}
}
