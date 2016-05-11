package com.sgm.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_group")
public class Student_group {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Course")
	private int course;

	@Column(name = "Professor_ID")
	private int professorID;

	@Column(name = "Subject_ID")
	private int subjectID;
	
	@Column(name = "Faculty_ID")
	private int facultyID;

}
