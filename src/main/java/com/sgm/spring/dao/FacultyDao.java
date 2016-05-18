package com.sgm.spring.dao;

import com.sgm.spring.model.Faculty;

public interface FacultyDao {

	public Faculty getFaculty(Long id);

	public void addFaculty(Faculty faculty);

	public void updateFaculty(Faculty faculty);

	public void deleteGrade(int id);

}
