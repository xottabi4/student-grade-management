package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.UniveristySubject;

public interface UniversitySubjectDao {

	public List<UniveristySubject> getSubjects();

	public List<UniveristySubject> getSubjects(Long facultyID);

	public List<UniveristySubject> getSubjects(String facultyTitle);

	public void addSubject(UniveristySubject subject);

	public void updateSubject(UniveristySubject subject);

	public void deleteSubject(int id);
}
