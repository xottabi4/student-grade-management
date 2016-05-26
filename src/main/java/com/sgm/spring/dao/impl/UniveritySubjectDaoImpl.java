package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.UniversitySubjectDao;
import com.sgm.spring.model.UniveristySubject;

@Repository
public class UniveritySubjectDaoImpl implements UniversitySubjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UniveristySubject> getSubjects() {
		String sql = "from UniveristySubject";
		Query query = getCurrentSession().createQuery(sql);
		List<UniveristySubject> subjects = query.list();
		return subjects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UniveristySubject> getSubjects(Long facultyID) {
		String sql = "from UniveristySubject u where u.faculty = :faculty";
		Query query = getCurrentSession().createQuery(sql).setParameter("faculty", facultyID);
		List<UniveristySubject> subjects = query.list();
		return subjects;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UniveristySubject> getSubjects(String facultyTitle) {
		String sql = "select u from UniveristySubject u "
				+ " inner join u.faculty f "
				+ "where f.title = :faculty";
		Query query = getCurrentSession().createQuery(sql).setParameter("faculty", facultyTitle);
		List<UniveristySubject> subjects = query.list();
		return subjects;
	}
	
	
	

	@Override
	public void addSubject(UniveristySubject subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSubject(UniveristySubject subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject(int id) {
		// TODO Auto-generated method stub
		
	}


}
