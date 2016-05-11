package com.sgm.spring.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Grade {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Title")
	private String title;
	
	@Column(name = "Date")
	private String date;

	@Column(name = "Description")
	private String description;


	@Column(name = "Grade")
	private int course;

	@Column(name = "Student_ID")
	private int professorID;

	@Column(name = "Task_ID")
	private int subjectID;
	
	@Column(name = "Group_ID")
	private int facultyID;
	
	
}
