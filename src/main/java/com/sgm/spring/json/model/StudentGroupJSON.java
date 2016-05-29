package com.sgm.spring.json.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentGroupJSON implements Serializable {

	@JsonProperty("students")
	private List<StudentJSON> students;
	private String groupTitle;
	private String facultyTitle;
	private String subjectTitle;
	private Long courseTitle;

	public String getFacultyTitle() {
		return facultyTitle;
	}

	public void setFacultyTitle(String facultyTitle) {
		this.facultyTitle = facultyTitle;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public Long getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(Long courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public List<StudentJSON> getStudents() {
		return students;
	}

	public void setStudents(List<StudentJSON> students) {
		this.students = students;
	}
}
