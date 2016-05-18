package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.model.Grade;

@Component
public class GradeDaoImpl implements GradeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Grade> getGrades(Long userID) {
		String sql = "from Grade g where g.studentID = :userID";
		Query query = getCurrentSession().createQuery(sql).setParameter("userID", userID);
		return query.list();
	}

	@Override
	public void updateGrade(Grade grade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGrade(Long id) {
		// TODO Auto-generated method stub

	}

}
