package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.User;

@Component
public class GradeDaoImpl implements GradeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addGrade(Grade grade) {
		getCurrentSession().save(grade);
	}

	@Override
	public Grade getGrade(Long id) {
		Grade grade = (Grade) getCurrentSession().get(Grade.class, id);
		return grade;
	}

	@Override
	public void updateGrade(Grade grade) {
		Grade gradeToUpdate = getGrade(grade.getId());
		gradeToUpdate.setDate(grade.getDate());
		gradeToUpdate.setDescription(grade.getDescription());
		gradeToUpdate.setGrade(grade.getGrade());
		gradeToUpdate.setStudent(grade.getStudent());
		gradeToUpdate.setStudentGroup(grade.getStudentGroup());
		gradeToUpdate.setTask(grade.getTask());
		gradeToUpdate.setTitle(grade.getTitle());
		getCurrentSession().update(gradeToUpdate);

	}

	@Override
	public void deleteGrade(Long id) {
		Grade grade = getGrade(id);
		getCurrentSession().delete(grade);

	}

	@Override
	public List<Grade> getGrades(Long groupID, String taskTitle) {
		String sql = "select g from Grade g "
				+ "inner join g.studentGroup as s "
				+ "inner join g.task as t "
				+ "where s.id = :groupID and "
				+ "t.title = :taskTitle ";
		Query query = getCurrentSession().createQuery(sql)
				.setParameter("groupID", groupID)
				.setParameter("taskTitle", taskTitle);
		return query.list();
	}

}
