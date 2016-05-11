package com.sgm.spring.dao;

import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;

public interface UniversitySubjectDao {

	UniveristySubject getSubject(Long id);
	public void addSubject(UniveristySubject subject);
	public void updateSubject(UniveristySubject subject);
	public void deleteSubject(int id);
}
