package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.User;
import com.sgm.spring.model.UserType;

public interface UserTypeDao {

	public UserType getType(Long typeID);

	public List<UserType> getTypes(User user);
	
	public boolean isStudent(User user);

}
