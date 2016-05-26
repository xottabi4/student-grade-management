package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.StudentGroup;

public interface StudentGroupDao {

	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle);


}
