package com.sgm.spring.dao;

import com.sgm.spring.model.Student;

public interface StudentDao {

	// for login
	public Student findByName(String name);

	public Student getStudent(Long id);

	public void addStudent(Student student);

	public void deleteStudentByID(Long id);

}
