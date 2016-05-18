package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.Grade;

public interface GradeDao {

	public void addGrade(Grade grade);

	public List<Grade> getGrades(Long userID);

	public void updateGrade(Grade grade);

	public void deleteGrade(Long id);

}
