package com.sgm.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgm.spring.dao.FacultyDao;
import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.dao.TaskDao;
import com.sgm.spring.dao.UniversitySubjectDao;
import com.sgm.spring.dao.UserDao;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.model.User;
import com.sgm.spring.service.ProfessorService;
import com.sgm.spring.service.StudentService;

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
//		Faculty faculty = facultyDao.getFaculty(facultyTitle);
//		return subjectDao.getSubjects(faculty.getId());
		return subjectDao.getSubjects(facultyTitle);
	}

}
