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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTasks() {
		String sql = "from " + Task.class.getName();
		Query query = getCurrentSession().createQuery(sql);
		List<Task> task = query.list();
		return task;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Task getTask(String taskTitle) {
		String sql = "from Task t where t.title = :title";
		Query query = getCurrentSession().createQuery(sql).setParameter("title", taskTitle);
		List<Task> tasks = query.list();
		return tasks.get(0);
	}

}
