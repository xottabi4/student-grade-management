package com.sgm.spring.dao.impl;

import com.sgm.spring.dao.GradeDao;

public interface GradeDaoImpl {
	
	public void addGroup(GradeDao group);
	public GradeDao getGroup(Long id);
	public void updateGroup(GradeDao group);
	public void deleteGroup(int id);

}
