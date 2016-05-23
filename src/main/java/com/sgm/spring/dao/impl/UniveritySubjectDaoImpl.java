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

	@Override
	public List<UniveristySubject> getSubjects() {
<<<<<<< HEAD
		String sql = "from UniveristySubject";
		Query query = getCurrentSession().createQuery(sql);
		List<UniveristySubject> subjects = query.list();
		return subjects;
=======
		  String sql = "from " + UniveristySubject.class.getName();
	        Query query = getCurrentSession().createQuery(sql);
	        List<UniveristySubject> subjects = query.list();
	        return subjects;
>>>>>>> 6615e4a69b73dc2bf8aa980f95285352cc796cc3
	}

	@Override
	public List<UniveristySubject> getSubjects(Long facultyID) {
		String sql = "from UniveristySubject u where u.faculty = :faculty";
		Query query = getCurrentSession().createQuery(sql).setParameter("faculty", facultyID);
		List<UniveristySubject> subjects = query.list();
		return subjects;
	}
	@Override
	public List<UniveristySubject> getSubjects(String facultyTitle) {
//		select a from Article a 
//		inner join a.categories c
//		where c.category = :categoryName
		String sql = "select u from UniveristySubject u inner join u.faculty f where f.title = :faculty";
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
