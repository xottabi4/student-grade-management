package com.sgm.spring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sgm.spring.model.Grade;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.service.StudentService;

@Controller
@Transactional
@EnableWebMvc
public class StudentController {
	@Autowired
	StudentService studentService;

	// @RequestMapping(value = "/student/subjects", method = RequestMethod.GET)
	// public String allStudentGrades(Model model, Principal principal) {
	// List<Grade> grades = studentService.getGrades(principal.getName());
	// model.addAttribute("studentGrades", grades);
	// return "student/studentSubjects";
	//
	// }

	@RequestMapping(value = "/student/subjects", method = RequestMethod.GET)
	public String allStudentSubjects(Model model, Principal principal) {
		List<UniveristySubject> subjects = studentService.getSubjects();
		List<Task> taskList = studentService.getTasks();
		List<Grade> grades = studentService.getGrades(principal.getName());
		model.addAttribute("studentGrades", grades);
		model.addAttribute("studentSubjects", subjects);
		model.addAttribute("studentTasks", taskList);
		return "student/studentSubjects";

	}

}
