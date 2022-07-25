package io.vishal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.vishal.entity.Course;
import io.vishal.entity.Guardian;
import io.vishal.entity.Student;
import io.vishal.entity.Teacher;
import io.vishal.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryManyToMany {

	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test  //this test will fail incase of duplicate value....be careful
	public void saveCourseWithStudentAndTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("raghu2")
				.lastName("rva2")
				.build();
		
		Student student = Student.builder()
				.firstName("aroha2")
				.lastName("kaman2")
				.emailId("arohakaman2@outlook.com")
				.guardian(Guardian.builder().name("basan2").email("basan2@kmail.com").mobile("9455735323").build())
				.build();
		
		Course course = Course.builder()
				.courseTitle("AI2")
				.credit(13)
				.teacher(teacher)
				.students(List.of(student))
				.build();
		
		//course.addStudents(student);
		
		courseRepository.save(course);
	}
	
}
