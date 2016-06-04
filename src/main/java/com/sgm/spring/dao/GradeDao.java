package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.Grade;

public interface GradeDao {

	public void addGrade(Grade grade);

	public List<Grade> getGrades(Long groupID, Long taskID);
	
	public List<Grade> getAllStudentGrades(Long groupID, Long userID);
	
	public List<Grade> getGrades(Long userID,Long groupID, Long taskID);

	public void updateGrade(Grade grade);

	public void deleteGrade(Long id);

	public Grade getGrade(Long id);

}
