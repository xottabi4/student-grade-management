package com.sgm.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sgm.spring.dao.FacultyDao;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.service.ProfessorService;

@Controller("/professor")
@Transactional
@EnableWebMvc
public class ProfessorController {
	/*
	 * @Autowired StudentService studentService;
	 * 
	 * @RequestMapping(value = "/student/grades", method = RequestMethod.GET)
	 * public String allStudentGrades(Model model, Principal principal) {
	 * List<Grade> grades = studentService.getGrades(principal.getName());
	 * model.addAttribute("studentGrades", grades); return
	 * "student/studentGrades";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/student/subjects", method = RequestMethod.GET)
	 * public String allStudentSubjects(Model model) { List<UniveristySubject>
	 * subjects = studentService.getSubjects(); List<Task> taskList =
	 * studentService.getTasks(); model.addAttribute("studentSubjects",
	 * subjects); model.addAttribute("studentTasks", taskList); return
	 * "student/studentSubjects";
	 * 
	 * }
	 */

	@Autowired
	ProfessorService professorService;

	@RequestMapping(value = "/professor/createGroup", method = RequestMethod.GET)
	public String getCreateGroup(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		for (Faculty faculty : facultys) {
			System.out.println(faculty.getTitle());
		}
		model.addAttribute("facultys", facultys);
		return "professor/professorCreateGroup";
	}

	@RequestMapping(value = "/professor/createGroup", method = RequestMethod.POST)
	public String postCreateGroup(Model model) {
		return "professor/professorCreateGroup";
	}

	@RequestMapping(value = "/professor/addGrades", method = RequestMethod.GET)
	public String getAddGrades(Model model) {
		return "professor/professorAddGrades";
	}
}
