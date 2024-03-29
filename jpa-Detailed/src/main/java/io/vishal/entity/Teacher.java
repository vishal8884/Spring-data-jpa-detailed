package io.vishal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

	@Id
	@SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="teacher_id", referencedColumnName = "teacherId")             //many to one is preferred by JPA team because for couuse obj teacher is complusory not vice versa
//	private List<Course> courses;
}
