package com.sgm.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
public class Grade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 896472859991174095L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Grade")
	private Long grade;

	@Column(name = "Date")
	private String date;

	@Column(name = "Description")
	private String description;

	@Column(name = "Student_ID")
	private Long studentID;

	@Column(name = "Task_ID")
	private Long subjectID;

	@Column(name = "Group_ID")
	private Long facultyID;

	public Long getId() {
		return id;
	}

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Long subjectID) {
		this.subjectID = subjectID;
	}

	public Long getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(Long facultyID) {
		this.facultyID = facultyID;
	}

}
