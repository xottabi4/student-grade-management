package com.sgm.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "student_group")
public class StudentGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5004118781786268667L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("groupID")
	private Long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Course")
	private Long course;

	@ManyToOne
	@JoinColumn(name = "Professor_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "Subject_ID")
	private UniveristySubject subject;

	@ManyToOne
	@JoinColumn(name = "Faculty_ID")
	private Faculty faculty;

	public Long getId() {
		return id;
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

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UniveristySubject getSubject() {
		return subject;
	}

	public void setSubject(UniveristySubject subject) {
		this.subject = subject;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

}
