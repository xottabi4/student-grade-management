package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.FacultyDao;
import com.sgm.spring.model.Faculty;

@Repository
public class FacultyDaoImpl implements FacultyDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Faculty getFaculty(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGrade(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Faculty> getFacultys() {
//		from User u where u.username
		String sql = "from Faculty";
		Query query = getCurrentSession().createQuery(sql);
		List<Faculty> faculty = query.list();
		return faculty;
	}
	

}
