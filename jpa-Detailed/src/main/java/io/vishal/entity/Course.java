package io.vishal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_id",referencedColumnName = "teacherId")                        //this and OneToMany no change in db..just change in objects
	private Teacher teacher;
}
