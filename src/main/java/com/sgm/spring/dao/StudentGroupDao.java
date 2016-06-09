package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.User;

public interface StudentGroupDao {

	public StudentGroup getGroup(Long groupID);

	public StudentGroup getGroup(String groupTitle);

	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle, User professor);

	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle);

	public List<StudentGroup> getAllGroups(Long facultyID);

	public void addGroup(StudentGroup studentGroup);

	public void deleteGroup(Long id);

	public void updateGroup(StudentGroup group);
}
