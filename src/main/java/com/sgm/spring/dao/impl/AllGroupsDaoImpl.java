package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgm.spring.dao.AllGroupsDao;
import com.sgm.spring.model.AllGroups;
import com.sgm.spring.model.User;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<AllGroups> getSelectedGroup(Long selectedGroupID) {
		String sql = "select g from AllGroups g " + "inner join g.studentGroup as s " + "where s.id = :groupID ";
		Query query = getCurrentSession().createQuery(sql).setParameter("groupID", selectedGroupID);
		return query.list();
	}

	@Override
	public void deleteGroups(Long studentGroupID) {
		String sql = "delete AllGroups g" + "where g.studentGroup = :groupID ";
		Query query = getCurrentSession().createQuery(sql).setParameter("groupID", studentGroupID);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getStudents(Long groupID) {
		String sql = "select g.student from AllGroups g " + "inner join g.studentGroup as s "
				+ "where s.id = :groupID ";
		Query query = getCurrentSession().createQuery(sql).setParameter("groupID", groupID);
		return query.list();
	}

	@Override
	public void deleteGroup(Long studentGroupID, Long userID) {
		String sql = "delete AllGroups g where g.studentGroup in ("
				+ "select sg from StudentGroup sg "
				+ "where sg.id = :groupID ) and "
				+ "g.student in ("
				+ "select s from User s "
				+ "where s.id = :userID )";
		Query query = getCurrentSession().createQuery(sql).setParameter("groupID", studentGroupID)
				.setParameter("userID", userID);
		query.executeUpdate();

	}
}
