package com.sgm.spring.dao;

import com.sgm.spring.model.StudentGroup;

public interface StudentGroupDao {
	
	
	
	
	public void addGroup(StudentGroup group);
	public StudentGroup getGroup(Long id);
	public void updateGroup(StudentGroup group); 
	public void deleteGroup(int id);

}
