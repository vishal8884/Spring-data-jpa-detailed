package io.vishal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.vishal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByfirstName(String firstName);
	
	public List<Student> findByfirstNameContaining(String name);
	
	public List<Student> findBylastNameNotNull();
	
	public List<Student> findByGuardianName(String guardianName);
	
	public Student findByFirstNameAndLastName(String firstName, String lastName);
	
	
	
	//jpql
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentByEmailAddress(String emailId);
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String getFirstNameByEmailAddress(String emailId);
	
	
	
	//native sql query
	@Query(nativeQuery = true, value = "select * from tbl_student s where s.email_address = ?1")
	public Student getStudentByEmailIdNative(String emailId);
}
