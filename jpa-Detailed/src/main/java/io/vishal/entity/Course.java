package io.vishal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {

	@Id
	@SequenceGenerator(name = "course_sequence" , sequenceName = "course_sequence" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	private Long courseId;
	
	private String courseTitle;
	
	private Integer credit;
	
	@OneToOne(mappedBy = "course")   //this says that already mapped by course attribute in CourseMaterial.class
	private CourseMaterial courseMaterial;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)                                                    // cascade type means when we update even the child table needs to updated or not
	@JoinColumn(name="teacher_id",referencedColumnName = "teacherId")                        //this and OneToMany no change in db..just change in objects
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)                          // fetch type eager fetches the students also in java object
	@JoinTable(name = "student_course_mapping", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
	                                          , inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))
	private List<Student> students;                                                          //new table needs to created for many to many
	
//	public void addStudents(Student student) {
//		if(students == null) {
//			students = new ArrayList<>();
//		}
//		students.add(student);
//	}
}
