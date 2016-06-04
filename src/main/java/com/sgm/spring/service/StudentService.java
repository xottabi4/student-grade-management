package com.sgm.spring.service;

import java.util.List;

import com.sgm.spring.model.AllGroups;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;

public interface StudentService {

	public List<Grade> getGrades(String userName,Long groupID, Long taskID);
	public List<Task>getTasks();
	public List<Double> getAverageGrade(List<Grade> grades);
	public List<Double> getAllAverageGrades(String userName, Long groupID);
	public List<Faculty> getFacultys();
	public List<UniveristySubject> getSubjects(Long facultyID);
	public List<UniveristySubject> getSubjects(String facultyTitle);
	public List<StudentGroup> getStudentGroups(String facultyTitle, String course, String subjectTitle);
	public List<StudentGroup> getAllStudentGroups(Long facultyID);
	
}
