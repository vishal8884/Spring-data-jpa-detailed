package io.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vishal.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
