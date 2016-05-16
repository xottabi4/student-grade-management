package com.sgm.spring.dao;

import com.sgm.spring.model.User;

public interface UserDao {

	public User getUser(Long id);

	public User getUser(String username, String password);
}
