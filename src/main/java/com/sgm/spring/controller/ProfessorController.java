package com.sgm.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
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

	@RequestMapping(value = "/professor/createGroup", method = RequestMethod.GET)
	public String createGroup(Model model) {
		return "professor/professorCreateGroup";
	}
}
