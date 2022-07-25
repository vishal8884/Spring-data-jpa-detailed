package io.vishal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import io.vishal.entity.Guardian;
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
				//.guardianName("bob")
				//.guardianEmail("bob2@outlook.com")
				//.guardianMobile("9483956683")
				.build();
		
		//studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.name("babar")
				.email("babar2@yahoo.com")
				.mobile("3247834343")
				.build();
		
		Student student = Student.builder()
				.emailId("sivamdube2@gmail.com")
				.firstName("sivam")
				.lastName("dube")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("student list :: "+studentList);
	}
	
	
	@Test
	public void getStudentByFirstName() {
		List<Student> students = studentRepository.findByfirstName("sivam");
		System.out.println("students obtained by firstName :: "+students);
	}
	
	
	@Test
	public void getStudentByFirstNameContaining() {
		List<Student> students = studentRepository.findByfirstNameContaining("si");
		System.out.println("students obtained by firstName containing :: "+students);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("bob");
		System.out.println("students obtained by guardian Name :: "+students);
	}
	
	@Test
	public void printGetStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("water@gmail.com");
		System.out.println("student by email address:: "+student);
	}
	
	@Test
	public void printGetFirstNameByEmailAddress() {
		String firstName = studentRepository.getFirstNameByEmailAddress("water@gmail.com");
		System.out.println("firstname by email address  :: "+firstName);
	}
	
	@Test
	public void printGetStudentByEmailAddressNativeQuery() {
		Student student = studentRepository.getStudentByEmailIdNative("water@gmail.com");
		System.out.println("student by email address native query:: "+student);
	}
}
