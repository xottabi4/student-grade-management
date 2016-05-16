package com.sgm.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sgm.spring.dao.UserTypeDao;
import com.sgm.spring.model.UserType;

public class UserTypeDaoImpl implements UserTypeDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public UserType getUser(Long id) {
		UserType userType = (UserType) getCurrentSession().get(UserType.class, id);
		return userType;
	}

}
