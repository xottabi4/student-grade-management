package com.sgm.spring.dao;

import com.sgm.spring.model.Grade;

public interface GradeDao {

	public void addGroup(Grade group);

	public Grade getGroup(Long id);

	public void updateGroup(Grade group);

	public void deleteGroup(int id);

}
