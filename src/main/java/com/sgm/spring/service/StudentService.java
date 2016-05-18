package com.sgm.spring.service;

import java.util.List;

import com.sgm.spring.model.Grade;

public interface StudentService {

	public List<Grade> getGrades(String userName);

}
