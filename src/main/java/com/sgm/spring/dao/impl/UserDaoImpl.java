package com.sgm.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.UserDao;
import com.sgm.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getUser(Long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public User getUser(String username, String password) {
//TODO finish this function
//		User user = (User) getCurrentSession().get(User.class, username, password);
//		User user = (User) getCurrentSession().ge
//		return user;
		return null;
	}

}
