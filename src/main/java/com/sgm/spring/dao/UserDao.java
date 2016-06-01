package com.sgm.spring.dao;

import com.sgm.spring.model.User;

public interface UserDao {
	
	public void addUser(User user);

	public User getUser(Long id);

	public User getUser(String username);
	
	public void updateUser(User user);

	public void deleteUser(Long id);

}
