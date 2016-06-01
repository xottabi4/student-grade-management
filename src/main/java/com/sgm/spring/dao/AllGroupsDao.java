package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.AllGroups;

public interface AllGroupsDao {

	public void addGroup(AllGroups group);

	// Update the table when a group is added

	public List<AllGroups> getSelectedGroup(Long selectedGroupID);
}
