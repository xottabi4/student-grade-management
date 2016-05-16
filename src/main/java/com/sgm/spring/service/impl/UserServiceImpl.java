package com.sgm.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgm.spring.dao.GradeDao;
import com.sgm.spring.dao.UserDao;
import com.sgm.spring.model.User;
import com.sgm.spring.service.UserService;


public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

}
