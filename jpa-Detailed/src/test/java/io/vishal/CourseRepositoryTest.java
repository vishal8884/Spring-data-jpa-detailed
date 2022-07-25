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
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses list :: "+courses);
	}
	
	//@Test
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
	
	/////////////////////////////////Start of pagination///////////////////////////////////////////////////////////
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		
		List<Course> courses_firstPageWithThreeRecords = courseRepository.findAll(firstPageWithThreeRecords).getContent();
		System.out.println("courses_firstPageWithThreeRecords :: "+courses_firstPageWithThreeRecords);

		List<Course> courses_second = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		System.out.println("courses_second :: "+courses_second);
		
		
		
		
		//total elements and pages if we go by page 1 logic
		long totalElements_page1Logic = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
		System.out.println("total elements page1 logic :: "+totalElements_page1Logic);
		
		long totalPages_byPage1Logic = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
		System.out.println("total pages page1 logic :: "+totalPages_byPage1Logic);
		
		
		
		
		//total elements and pages if we go by page 2 logic
		long totalElements_page2Logic = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		System.out.println("total elements page2 logic:: "+totalElements_page2Logic);
				
		long totalPages_byPage2Logic = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
		System.out.println("total pages page2 logic:: "+totalPages_byPage2Logic);
	}
	
	@Test
	public void findAllPaginationWithSorting() {
		Pageable sortByTitle = PageRequest.of(0,2,Sort.by("courseTitle"));
		Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("courseTitle").descending().and(Sort.by("credit")));
		
		List<Course> course_sortByTitle = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("course_sortByTitle :: "+course_sortByTitle);
		
		List<Course> course_sortByCreditDesc = courseRepository.findAll(sortByCreditDesc).getContent();
		System.out.println("course_sortByCreditDesc :: "+course_sortByCreditDesc);
		
		List<Course> course_sortByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
		System.out.println("course_sortByTitleAndCreditDesc :: "+course_sortByTitleAndCreditDesc);
	}
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPage_tenRecords = PageRequest.of(0, 10);
		
		List<Course> courses_firstPage_tenRecords = courseRepository.findByCourseTitleContaining("P",firstPage_tenRecords).getContent();  //D is starting like *
		System.out.println("courses_firstPage_tenRecords :: "+courses_firstPage_tenRecords);
	}
	
	////////////////////////////////////////////////END of pagination and sorting////////////////////////////////////////////////////////////////////////
	
//	@Test
//	public void saveCourseWithStudentAndTeacher() {
//		
//		Teacher teacher = Teacher.builder()
//				.firstName("raghu")
//				.lastName("rva")
//				.build();
//		
//		Student student = Student.builder()
//				.firstName("aroha")
//				.lastName("kaman")
//				.emailId("arohakaman@outlook.com")
//				.guardian(Guardian.builder().name("basan").email("basan@kmail.com").mobile("9452735323").build())
//				.build();
//		
//		Course course = Course.builder()
//				.courseTitle("AI")
//				.credit(12)
//				.teacher(teacher)
//				.build();
//		
//		course.addStudents(student);
//		
//		courseRepository.save(course);
//	}
	
}
