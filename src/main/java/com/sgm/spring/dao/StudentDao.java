package com.sgm.spring.dao;

import com.sgm.spring.model.Professor;
import com.sgm.spring.model.Student;

public interface StudentDao {
	
	// for login
	Professor findByName(String name);

	Professor getStudent(Long id);
	
	void addStudent(Student student);

	void deleteStudentByID(Long id);

}
