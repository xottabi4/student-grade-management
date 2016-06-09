package com.sgm.spring.service;

import java.util.List;

import com.sgm.spring.exceptions.UserDoesntExistException;
import com.sgm.spring.exceptions.UserIsNotStudentException;
import com.sgm.spring.model.AllGroups;
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

	public List<StudentGroup> getStudentGroup(String facultyTitle, String course, String subjectTitle,
			String professorTitle);

	public List<Grade> getGrades(Long groupID, Long taskID);

	public List<AllGroups> getSelectedGroup(Long selectedGroupID);

	public List<Double> getAverageGrade(List<AllGroups> students, List<Grade> grades);

	public List<Task> getTasks();

	public void addStudentGrades(List<Grade> grades);

	public void addStudentsToGroup(List<User> students, Long groupID)
			throws UserDoesntExistException, UserIsNotStudentException;

	public void addStudentGroup(String groupTitle, Long course, String professorName, String subjectTitle,
			String facultyTitle);

	public void deleteGroup(Long id);

	public List<User> getStudentsInGroup(Long groupID);

	public void removeStudentFromGroup(Long groupID, Long userID);

	public void updateStudentGroup(Long groupID, String newGroupTitle);
}
