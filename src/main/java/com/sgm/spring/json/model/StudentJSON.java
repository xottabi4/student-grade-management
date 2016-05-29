package com.sgm.spring.json.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentJSON implements Serializable{
	private Long matrikula;
	private String name;
	private String surname;

	public Long getMatrikula() {
		return matrikula;
	}

	public void setMatrikula(Long matrikula) {
		this.matrikula = matrikula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
