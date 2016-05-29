package com.sgm.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgm.spring.dao.FacultyDao;
import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.dao.StudentGroupDao;
import com.sgm.spring.dao.TaskDao;
import com.sgm.spring.dao.UniversitySubjectDao;
import com.sgm.spring.dao.UserDao;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
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
		return studentGroupDao.getGroups(facultyTitle.trim(), courseID,
				subjectTitle.trim());
	}

	@Override
	public List<Grade> getGrades(int groupID, int taskID ) {
		Long groupIDLong= new Long(groupID);
		Long taskIDLong= new Long(taskID);
		return gradeDao.getGrades(groupIDLong, taskIDLong);
	}

	@Override
	public List<Task> getTasks() {
		return taskDao.getTasks();
	}
	

}
