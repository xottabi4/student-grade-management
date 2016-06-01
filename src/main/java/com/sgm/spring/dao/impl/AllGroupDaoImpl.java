package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.AllGroupDao;
import com.sgm.spring.model.AllGroups;

@Repository
public class AllGroupDaoImpl implements AllGroupDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public  List<AllGroups> getSelectedGroup(Long selectedGroupID) {
		String sql = "select g from AllGroups g "
				+ "inner join g.studentGroup as s "
				+ "where s.id = :groupID ";
		Query query = getCurrentSession().createQuery(sql)
				.setParameter("groupID", selectedGroupID);
		return query.list();
				
	}

}
