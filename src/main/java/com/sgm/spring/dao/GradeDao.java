package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.Grade;

public interface GradeDao {

	public void addGrade(Grade grade);

	public List<Grade> getGrades(Long groupID, String taskTitle);

	public void updateGrade(Grade grade);

	public void deleteGrade(Long id);

	public Grade getGrade(Long id);

}
