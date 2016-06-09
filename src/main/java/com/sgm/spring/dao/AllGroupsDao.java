package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.AllGroups;
import com.sgm.spring.model.User;

public interface AllGroupsDao {

	public void addGroup(AllGroups group);

	public List<AllGroups> getSelectedGroup(Long selectedGroupID);

	public void deleteGroups(Long studentGroupID);
	
	public void deleteGroup(Long studentGroupID, Long userID);
	
	public List<User> getStudents(Long groupID);
}
