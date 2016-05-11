package com.sgm.spring.dao;

import com.sgm.spring.model.Professor;

public interface ProfessorDao {

	// for login
	Professor findByName(String name);

	Professor getProfessor(Long id);
	
	void saveProfessor(Professor professor);

	void deleteProfessorByID(Long id);
}
