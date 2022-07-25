package io.vishal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.vishal.entity.Course;
import io.vishal.entity.Teacher;
import io.vishal.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDBA = Course.builder()
				.courseTitle("DBA")
				.credit(5)
				.build();
		
		Course coursePython = Course.builder()
				.courseTitle("Python")
				.credit(5)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Qutab")
				.lastName("khan")
				.courses(List.of(courseDBA,coursePython))
				.build();
		
		teacherRepository.save(teacher);
	}
}
