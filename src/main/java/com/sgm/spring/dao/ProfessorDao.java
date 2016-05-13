package com.sgm.spring.dao;

import com.sgm.spring.model.Professor;

public interface ProfessorDao {

	// for login
	public Professor findByName(String name);

	public Professor getProfessor(Long id);
	
	public void addProfessor(Professor professor);

	public void deleteProfessorByID(Long id);
}
