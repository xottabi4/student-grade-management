package com.sgm.spring.model.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sgm.spring.model.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentGroupJSON implements Serializable {

	@JsonProperty("students")
	private List<User> students;
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

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

}
