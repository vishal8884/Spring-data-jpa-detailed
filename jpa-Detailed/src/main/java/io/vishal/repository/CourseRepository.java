package io.vishal.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vishal.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

	//List<Course> findBycourseTitleitleContaining(String title, PageRequest pageRequest);
}
