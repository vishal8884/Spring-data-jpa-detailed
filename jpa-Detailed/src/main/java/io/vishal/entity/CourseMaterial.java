package io.vishal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "course")     //this excludes course object in tostring
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
	private Long courseMaterialId;
	
	private String url;
	
	//fetch type --> do we need to fetch coach table also or only its id...
	//lazy --> eg     CourseMaterial(courseMaterialId=6, url=www.web2dev.com)]
	//Eager --> eg    [CourseMaterial(courseMaterialId=2, url=www.google.com, course=Course(courseId=1, courseTitle=DSA, credit=6))
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false) // cascade gives permission to save course table along with this
	@JoinColumn(name = "course_id", referencedColumnName = "courseId")
	private Course course;

}
