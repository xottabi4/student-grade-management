package com.sgm.spring.service;

import java.util.List;

import com.sgm.spring.model.Grade;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;

public interface StudentService {

	public List<Grade> getGrades(String userName);
	public List<UniveristySubject>getSubjects();
	public List<Task>getTasks();
	
}
