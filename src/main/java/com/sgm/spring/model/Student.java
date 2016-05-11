package com.sgm.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Surname")
	private String surname;

	public Long getId() {
		return id;
	}

//	public Student(Long id, String name, String surname) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.surname = surname;
//	}

	public void setId(Long id) {
		this.id = id;
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
