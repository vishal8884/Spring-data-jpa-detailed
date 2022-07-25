package io.vishal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.vishal.entity.Course;
import io.vishal.entity.Teacher;
import io.vishal.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses list :: "+courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher =Teacher.builder()
				.firstName("gomex")
				.lastName("andex")
				.build();
		
		Course course = Course.builder()
				.courseTitle("dotnet")
				.credit(7)
				.teacher(teacher)
				.build();
		
		courseRepository.save(course);
	}
}
