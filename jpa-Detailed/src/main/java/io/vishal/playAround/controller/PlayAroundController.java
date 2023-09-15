package io.vishal.playAround.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.vishal.entity.Course;
import io.vishal.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PlayAroundController {
	
	@Autowired
	private CourseRepository courseRepo;

	@PostMapping("/course/insert")
	public ResponseEntity<String> insertStudents(@RequestBody Course course){
		try {
			System.out.println("Saving course :: "+course);
			courseRepo.save(course);
		} catch (Exception e) {
			log.error("Exception occured while saving course :: {}",e.getLocalizedMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().body("Success");
	}
}
