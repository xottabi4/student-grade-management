package com.sgm.spring.service;

import java.util.List;

import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.UniveristySubject;

public interface ProfessorService {

	// public List<Grade> getGrades(String userName);
	// public List<Task>getTasks();
	public List<Faculty> getFacultys();

//	public List<UniveristySubject> getSubjects();

	public List<UniveristySubject> getSubjects(Long facultyID);
	public List<UniveristySubject> getSubjects(String facultyTitle);

}
