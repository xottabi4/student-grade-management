package com.sgm.spring.model.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sgm.spring.model.Grade;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentGradeJSON implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3224848236457416583L;

	@JsonProperty("groupGrades")
	private List<Grade> groupGrades;

	public List<Grade> getGroupGrades() {
		return groupGrades;
	}

	public void setGroupGrades(List<Grade> groupGrades) {
		this.groupGrades = groupGrades;
	}

}
