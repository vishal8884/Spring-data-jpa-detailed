package io.vishal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	
	
	//native name paramater same as sql query
	@Query(nativeQuery = true, value = "select * from tbl_student s where s.email_address = :emailId")
	public Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update tbl_student set first_name =?1 where email_address =?2")
	int updateStudentNameByEmailId(String firstName, String emailId);
}
