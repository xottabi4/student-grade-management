package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgm.spring.dao.AllGroupsDao;
import com.sgm.spring.model.AllGroups;

@Component
public class AllGroupsDaoImpl implements AllGroupsDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addGroup(AllGroups group) {
		getCurrentSession().save(group);
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
