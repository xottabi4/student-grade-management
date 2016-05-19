package com.sgm.spring.dao;

import java.util.List;

import com.sgm.spring.model.UniveristySubject;

public interface UniversitySubjectDao {

	public List<UniveristySubject> getSubjects();

	public void addSubject(UniveristySubject subject);

	public void updateSubject(UniveristySubject subject);

	public void deleteSubject(int id);
}
