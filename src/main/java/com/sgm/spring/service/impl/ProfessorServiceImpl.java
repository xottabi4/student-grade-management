package com.sgm.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgm.spring.dao.AllGroupsDao;
import com.sgm.spring.dao.FacultyDao;
import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.dao.StudentGroupDao;
import com.sgm.spring.dao.TaskDao;
import com.sgm.spring.dao.UniversitySubjectDao;
import com.sgm.spring.dao.UserDao;
import com.sgm.spring.exceptions.UserDoesntExistException;
import com.sgm.spring.model.AllGroups;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.model.User;
import com.sgm.spring.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	UserDao userDao;
	@Autowired
	GradeDao gradeDao;
	@Autowired
	UniversitySubjectDao subjectDao;
	@Autowired
	TaskDao taskDao;
	@Autowired
	FacultyDao facultyDao;
	@Autowired
	StudentGroupDao studentGroupDao;
	@Autowired
	AllGroupsDao allGroupsDao;

	@Override
	public List<Faculty> getFacultys() {
		return facultyDao.getFacultys();
	}

	@Override
	public List<UniveristySubject> getSubjects(Long facultyID) {
		return subjectDao.getSubjects(facultyID);
	}

	@Override
	public List<UniveristySubject> getSubjects(String facultyTitle) {
		// Faculty faculty = facultyDao.getFaculty(facultyTitle);
		// return subjectDao.getSubjects(faculty.getId());
		return subjectDao.getSubjects(facultyTitle.trim());
	}

	@Override
	public List<StudentGroup> getStudentGroup(String facultyTitle, String course, String subjectTitle) {
		Long courseID = Long.valueOf(course.trim()).longValue();
		return studentGroupDao.getGroups(facultyTitle.trim(), courseID, subjectTitle.trim());
	}

	@Override
	public List<Grade> getGrades(Long groupID, Long taskID) {
		return gradeDao.getGrades(groupID, taskID);
	}

	@Override
	public List<Double> getAverageGrade(List<AllGroups> students, List<Grade> grades) {

		List<Double> studentAverageGrades = new ArrayList<>();
		double averageGrade = 0;
		int i = 0;
		for (int j = 0; j < students.size(); j++) {
			averageGrade = 0;
			i = 0;
			for (Grade grade : grades) {
				if (grade.getStudent().getId() == students.get(j).getStudent().getId()) {
					averageGrade += (double) grade.getGrade();
					i++;
				}
			}
			averageGrade = averageGrade / i;
			studentAverageGrades.add(averageGrade);
		}
		return studentAverageGrades;
	}

	@Override
	public List<Task> getTasks() {
		return taskDao.getTasks();
	}

	@Override
	public void addStudentsToGroup(List<User> students, Long groupID) throws UserDoesntExistException {
		AllGroups allGroup;
		for (User student : students) {
			if (userDao.containsUser(student)) {
				allGroup = new AllGroups();
				allGroup.setId((long) 0);
				allGroup.setStudent(student);
				allGroup.setStudentGroup(studentGroupDao.getGroup(groupID));
				allGroupsDao.addGroup(allGroup);
			} else {
				throw new UserDoesntExistException("User with id " + student.getId() + " doesnt exist!");
			}
		}
	}

	@Override
	public Long addStudentGroup(String groupTitle, Long course, String professorTitle, String subjectTitle,
			String facultyTitle) {
		User professor = userDao.getUser(professorTitle);
		UniveristySubject subject = subjectDao.getSubject(subjectTitle);
		Faculty faculty = facultyDao.getFaculty(facultyTitle);
		StudentGroup studentGroup = new StudentGroup();
		studentGroup.setUser(professor);
		studentGroup.setCourse(course);
		studentGroup.setTitle(groupTitle);
		studentGroup.setSubject(subject);
		studentGroup.setFaculty(faculty);
		Long createdGroupID = studentGroupDao.addGroup(studentGroup);
		return createdGroupID;
	}

	@Override
	public List<AllGroups> getSelectedGroup(Long selectedGroupID) {
		return allGroupsDao.getSelectedGroup(selectedGroupID);
	}

	@Override
	public void addStudentGrades(List<Grade> grades) {
		for (Grade grade : grades) {
			gradeDao.addGrade(grade);
		}
	}

}
