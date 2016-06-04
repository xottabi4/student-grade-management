package com.sgm.spring.service.impl;

import java.util.ArrayList;
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
	@Autowired
	StudentGroupDao studentGroupDao;
	@Autowired
	FacultyDao facultyDao;

	@Override
	public List<Grade> getGrades(String userName, Long groupID, Long taskID) {
		User user = userDao.getUser(userName);
		Long id = user.getId();
		return gradeDao.getGrades(id, groupID, taskID);
	}

	@Override
	public List<Task> getTasks() {
		return taskDao.getTasks();
	}

	@Override
	public List<Double> getAverageGrade(List<Grade> grades) {
		List<Double> studentAverageGrade = new ArrayList<>();
		double averageGrade = 0;
		for (Grade grade : grades) {
			averageGrade += (double) grade.getGrade();
		}
		averageGrade = (averageGrade / grades.size());
		studentAverageGrade.add(averageGrade);
		return studentAverageGrade;
	}

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
		return subjectDao.getSubjects(facultyTitle.trim());
	}

	@Override
	public List<StudentGroup> getStudentGroups(String facultyTitle, String course, String subjectTitle) {
		Long courseID = Long.valueOf(course.trim()).longValue();
		return studentGroupDao.getGroups(facultyTitle.trim(), courseID, subjectTitle.trim());
	}

	@Override
	public List<Double> getAllAverageGrades(String userName, Long groupID) {
		List<Double> averageTaskGrade = new ArrayList<>();
		double averageGrade = 0;
		User user = userDao.getUser(userName);
		Long id = user.getId();
		boolean checkTaskRecords = true;
		List<Grade> grades = gradeDao.getAllStudentGrades(groupID, id);
		List<Task> tasks = taskDao.getTasks();
		int i = 0;
		boolean[] recordTasks = new boolean[tasks.size()];
		System.out.println(recordTasks.length);
		for (Task task : tasks) {
			averageGrade = 0;
			i = 0;
			checkTaskRecords = true;
			for (Grade grade : grades) {
				if (task.getId() == grade.getTask().getId()) {
					averageGrade = grade.getGrade() + averageGrade;
					i++;
					checkTaskRecords = false;
				}
			}
			if (checkTaskRecords == false) {
				recordTasks[((int) task.getId().longValue() - 1)] = false;
				averageGrade = averageGrade / i;
				averageTaskGrade.add(averageGrade);
			} else {
				averageTaskGrade.add(0.0);
				recordTasks[((int) task.getId().longValue() - 1)] = true;
			}
		}
		averageGrade = 0;
		i = 0;
		for (int j = 0; j < averageTaskGrade.size(); j++) {
			if (recordTasks[j] == false) {
				averageGrade = averageGrade + averageTaskGrade.get(j);
				i++;
			}
		}
		averageGrade = averageGrade / i;
		averageTaskGrade.add(averageGrade);
		return averageTaskGrade;
	}

	@Override
	public List<StudentGroup> getAllStudentGroups(Long facultyID){
		return studentGroupDao.getAllGroups(facultyID);
	}
}
