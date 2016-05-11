package com.sgm.spring.dao;

import com.sgm.spring.model.Grade;

public interface Grade {
	
	public void addGroup(GradeDao group);
	public GradeDao getGroup(Long id);
	public void updateGroup(GradeDao group);
	public void deleteGroup(int id);

}
