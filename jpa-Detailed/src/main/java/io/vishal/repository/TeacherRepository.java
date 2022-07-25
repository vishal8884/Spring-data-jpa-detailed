package io.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.vishal.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
