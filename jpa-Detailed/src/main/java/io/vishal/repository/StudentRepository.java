package io.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vishal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
