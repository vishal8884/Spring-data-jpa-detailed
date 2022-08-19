package io.vishal.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.vishal.entity.Course;
import io.vishal.entity.Teacher;
import io.vishal.repository.CourseRepository;
import io.vishal.repository.TeacherRepository;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TeacherRepository teacherRespository;
	
	@GetMapping(value = "/findallCourse")
	public ResponseEntity<List<Course>> findAllCourse() {
		List<Course> allCourseList = courseRepository.findAll();
		
		return new ResponseEntity<List<Course>>(allCourseList,HttpStatus.OK);
	}
	
	
	///////////////////////////Teacher/////////////////////////////////////////////////////////////////
	
	@GetMapping(value = "/findallTeacher")
	public ResponseEntity<List<Teacher>> findAllTeacher() {
		List<Teacher> allTeachersList = teacherRespository.findAll();
		
		return new ResponseEntity<List<Teacher>>(allTeachersList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/teacher/{id}")
	public ResponseEntity<Teacher> findAllTeacherbyId(@PathVariable("id") long teacherId) {
		Teacher teacher = teacherRespository.findById(teacherId).orElse(null);
		return new ResponseEntity<>(teacher,HttpStatus.OK);
	}
	
	@GetMapping(value = "/findallTeacherPagination" ,params = {"page","size"})                                    // it works like this also without params here             //@GetMapping(value = "/findallTeacherPagination") 
	public ResponseEntity<List<Teacher>> findAllTeacherPagination(@RequestParam("page") int page, @RequestParam int size) {
		
		Pageable pageable = PageRequest.of(page,size);
		List<Teacher> allTeachersList = teacherRespository.findAll(pageable).getContent();
		return new ResponseEntity<List<Teacher>>(allTeachersList,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/findallTeacherPagination/sorted" ,params = {"page","size"})                                    // it works like this also without params here             //@GetMapping(value = "/findallTeacherPagination") 
	public ResponseEntity<List<Teacher>> findAllTeacherPaginationSorted(@RequestParam("page") int page, @RequestParam int size) {
		
		Pageable pageable = PageRequest.of(page,size,Sort.by("firstName"));
		List<Teacher> allTeachersList = teacherRespository.findAll(pageable).getContent();
		return new ResponseEntity<List<Teacher>>(allTeachersList,HttpStatus.OK);
	}
}
