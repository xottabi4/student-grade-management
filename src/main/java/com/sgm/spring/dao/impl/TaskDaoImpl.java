package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.TaskDao;
import com.sgm.spring.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Task> getTasks() {
		String sql = "select title from " + Task.class.getName() + " title";
		Query query = getCurrentSession().createQuery(sql);
		List<Task> task = query.list();
		return task;
	}

}
