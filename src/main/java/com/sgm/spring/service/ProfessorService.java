package com.sgm.spring.service;

import java.util.List;

import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.model.User;

public interface ProfessorService {

	public List<Faculty> getFacultys();

	public List<UniveristySubject> getSubjects(Long facultyID);

	public List<UniveristySubject> getSubjects(String facultyTitle);

	public List<StudentGroup> getStudentGroup(String facultyTitle, String course, String subjectTitle);

	public List<Grade> getGrades(Long groupID, Long taskID);

	public List<Task> getTasks();

	public void addStudentGroup(String groupTitle, String facultyTitle, String subjectTitle, Long courseTitle,
			Long professorID);

	public void addStudentsToGroup(List<User> students, Long groupID);
}
