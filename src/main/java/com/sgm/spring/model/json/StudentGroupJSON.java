package com.sgm.spring.model.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sgm.spring.model.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentGroupJSON implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7940678267276677886L;
	@JsonProperty("students")
	private List<User> students;
	private Long groupID;

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public Long getGroupID() {
		return groupID;
	}

	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}

	
}
