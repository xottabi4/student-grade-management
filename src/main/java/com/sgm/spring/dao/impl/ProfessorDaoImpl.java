package com.sgm.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.ProfessorDao;
import com.sgm.spring.model.Professor;

@Repository
public class ProfessorDaoImpl implements ProfessorDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Professor getProfessor(Long id) {
		Professor professor = (Professor) getCurrentSession().get(Professor.class, id);
		return professor;
	}

	@Override
	public void deleteProfessorByID(Long id) {
		Professor professor = getProfessor(id);
		if (professor != null) {
			getCurrentSession().delete(professor);
		}
	}

	@Override
	public Professor findByName(String name) {
		Professor professor = (Professor) getCurrentSession().get(Professor.class, name);
		return professor;
	}

	@Override
	public void addProfessor(Professor professor) {
		getCurrentSession().save(professor);
	}
}
