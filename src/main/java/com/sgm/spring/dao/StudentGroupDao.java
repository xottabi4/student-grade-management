package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.StudentGroup;

public interface StudentGroupDao {

	public StudentGroup getGroup(Long groupID);
	
	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle);

	public Long addGroup(StudentGroup studentGroup);
}
