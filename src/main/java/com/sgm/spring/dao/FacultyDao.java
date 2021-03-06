package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.Faculty;

public interface FacultyDao {

	public Faculty getFaculty(Long id);

	public Faculty getFaculty(String title);

	public void addFaculty(Faculty faculty);

	public void updateFaculty(Faculty faculty);

	public void deleteGrade(int id);

	public List<Faculty> getFacultys();

}
