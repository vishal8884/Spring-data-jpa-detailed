package io.vishal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vishal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByfirstName(String firstName);
	
	public List<Student> findByfirstNameContaining(String name);
	
	public List<Student> findBylastNameNotNull();
	
	public List<Student> findByGuardianName(String guardianName);
	
	public Student findByFirstNameAndLastName(String firstName, String lastName);
}
