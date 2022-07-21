package io.vishal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import io.vishal.entity.Student;
import io.vishal.repository.StudentRepository;

//@DataJpaTest    //ideally this should be used as it does not impact database
@SpringBootTest 
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student  = Student.builder()
				.emailId("water2@gmail.com")
				.firstName("water")
				.lastName("james")
				.guardianName("bob")
				.guardianEmail("bob2@outlook.com")
				.guardianMobile("9483956683")
				.build();
		
		//studentRepository.save(student);
	}
	
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("student list :: "+studentList);
	}
	
	
}
