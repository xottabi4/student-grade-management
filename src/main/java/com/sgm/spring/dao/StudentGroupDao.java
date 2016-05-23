package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.Task;

public interface StudentGroupDao {

	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle);


}
