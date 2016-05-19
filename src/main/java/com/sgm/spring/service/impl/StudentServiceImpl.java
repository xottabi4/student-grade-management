package com.sgm.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.dao.TaskDao;
import com.sgm.spring.dao.UniversitySubjectDao;
import com.sgm.spring.dao.UserDao;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.model.User;
import com.sgm.spring.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	UserDao userDao;
	@Autowired
	GradeDao gradeDao;
	@Autowired
	UniversitySubjectDao subjectDao;
	@Autowired
	TaskDao taskDao;

	@Override
	public List<Grade> getGrades(String userName) {
		User user = userDao.getUser(userName);
		Long id =user.getId();
		return gradeDao.getGrades(id);
	}

	@Override
	public List<UniveristySubject> getSubjects() {
		return subjectDao.getSubjects();
	}

	@Override
	public List<Task> getTasks() {
		return taskDao.getTasks();
	}


}
