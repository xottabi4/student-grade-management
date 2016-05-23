package com.sgm.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.service.ProfessorService;

@Controller("/professor")
@Transactional
@EnableWebMvc
public class ProfessorController {
	@Autowired
	ProfessorService professorService;

	@RequestMapping(value = "/professor/createGroup", method = RequestMethod.GET)
	public String getCreateGroup(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorCreateGroup";
	}

	// get courses controller with post
	@RequestMapping(value = "/professor/createGroup/viewCourses", method = RequestMethod.GET)
	public String getViewCourses(Model model) {
		return "professor/professorViewCourses";
	}

	// get subjects controller with post
	@RequestMapping(value = "/professor/createGroup/viewSubjects", method = RequestMethod.POST)
	public String getViewSubjects(@RequestParam(value = "selectedFaculty") String selectedFacultyTitle, Model model) {
		List<UniveristySubject> subjects = professorService.getSubjects(selectedFacultyTitle);
		model.addAttribute("subjects", subjects);
		return "professor/professorViewSubjects";
	}

	// get group controller with post
	@RequestMapping(value = "/professor/createGroup/viewGroups", method = RequestMethod.POST)
	public String getViewGroups(@RequestParam(value = "selectedFaculty") String selectedFacultyTitle,
			@RequestParam(value = "selectedSubject") String selectedSubjectTitle,
			@RequestParam(value = "selectedCourse") String selectedCourseID, Model model) {
		List<StudentGroup> groups = professorService.getStudentGroup(selectedFacultyTitle, selectedCourseID,
				selectedSubjectTitle);
		model.addAttribute("groups", groups);
		return "professor/professorViewGroups";
	}

	// TODO PROFESSOR CREATE GROUP

	// get students from selected group controller with post
	@RequestMapping(value = "/professor/createGroup/viewStudents", method = RequestMethod.POST)
	public String getViewStudents(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorCreateGroup";
	}

	// @RequestMapping(value = "/professor/createGroup", method =
	// RequestMethod.POST)
	// public String postCreateGroup(RedirectAttributes redirectAttributes) {
	// return "redirect:/professor/createGroup";
	// }

	@RequestMapping(value = "/professor/addGrades", method = RequestMethod.GET)
	public String getAddGrades(Model model) {
		return "professor/professorAddGrades";
	}
}
