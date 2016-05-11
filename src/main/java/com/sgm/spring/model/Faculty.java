package com.sgm.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Title")
	private String title;
	
	
}
