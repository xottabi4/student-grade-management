package com.sgm.spring.service;

import com.sgm.spring.model.Professor;

public interface ProfessorService {
	Professor findByName(String name);

	Professor getProfessor(Long id);

	void addProfessor(Professor professor);

	void deleteProfessorByID(Long id);
}