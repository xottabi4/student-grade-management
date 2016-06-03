package com.sgm.spring.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sgm.spring.json.JsonResponse;
import com.sgm.spring.model.AllGroups;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.Task;
import com.sgm.spring.model.UniveristySubject;
import com.sgm.spring.model.json.StudentGradeJSON;
import com.sgm.spring.model.json.StudentGroupJSON;
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

	@RequestMapping(value = "/professor/createGroup", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createGroup(@RequestParam(value = "selectedFaculty") String selectedFacultyTitle,
			@RequestParam(value = "selectedSubject") String selectedSubjectTitle,
			@RequestParam(value = "selectedCourse") Long selectedCourseID,
			@RequestParam(value = "groupTitle") String groupTitle, Principal principal) {
		String userName = principal.getName();
		professorService.addStudentGroup(groupTitle, selectedCourseID, userName, selectedSubjectTitle,
				selectedFacultyTitle);
		return new JsonResponse("Successfully created group", true);
	}

	@RequestMapping(value = "/professor/addStudentsToGroup", method = RequestMethod.GET)
	public String getAddStudentsToGroup(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorAddStudentsToGroup";
	}

	@RequestMapping(value = "/professor/addStudentsToGroup", method = RequestMethod.POST)
	public @ResponseBody JsonResponse addStudentsToGroup(@RequestBody StudentGroupJSON students) {
		try {
			professorService.addStudentsToGroup(students.getStudents(), students.getGroupID());
			return new JsonResponse("Successfully added students to group", true);
		} catch (Exception ex) {
			return new JsonResponse(ex.getMessage(), false);
		}
	}

	@RequestMapping(value = "/professor/setStudentGrades", method = RequestMethod.POST)
	public @ResponseBody String addStudentGrades(@RequestBody StudentGradeJSON grades)
			throws ParseException, IOException, HttpMessageNotReadableException {
		try {
			List<Grade> gradeList = grades.getGroupGrades();
			professorService.addStudentGrades(gradeList);
			return "Successfully added all student grades!";

		} catch (Exception ex) {
		}
		return "Failure!";
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

	// get tasks controller with post
	@RequestMapping(value = "/professor/createGroup/viewTasks", method = RequestMethod.POST)
	public String getViewTasks(Model model) {
		List<Task> tasks = professorService.getTasks();
		model.addAttribute("tasks", tasks);
		return "professor/professorViewTasks";
	}

	@RequestMapping(value = "/professor/viewGrades/getGrades", method = RequestMethod.GET)
	public @ResponseBody List<Grade> getGrades(@RequestParam(value = "selectedGroupID") Long selectedGroupID,
			@RequestParam(value = "selectedTaskID") Long selectedTaskID) {
		List<Grade> grades = professorService.getGrades(selectedGroupID, selectedTaskID);
		return grades;
	}

	@RequestMapping(value = "/professor/viewGrades/averageGrade", method = RequestMethod.GET)
	public @ResponseBody List<Double> getStudentAverageGrade(@RequestParam(value = "selectedGroupID") Long selectedGroupID,
			@RequestParam(value = "selectedTaskID") Long selectedTaskID) {
		List<AllGroups> selectedGroup = professorService.getSelectedGroup(selectedGroupID);
		List<Grade> grades = professorService.getGrades(selectedGroupID, selectedTaskID);
		List<Double> averageGrades = professorService.getAverageGrade(selectedGroup, grades);
		return averageGrades;
	}
	
	
	// to get all students for current group
	@RequestMapping(value = "/professor/addGrades/setGrades", method = RequestMethod.GET)
	public @ResponseBody List<AllGroups> getStudents(@RequestParam(value = "selectedGroupID") Long selectedGroupID) {
		List<AllGroups> selectedGroup = professorService.getSelectedGroup(selectedGroupID);
		return selectedGroup;
	}

	@RequestMapping(value = "/professor/viewGrades", method = RequestMethod.GET)
	public String getViewGrades(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorViewGrades";
	}

	@RequestMapping(value = "/professor/addGrades", method = RequestMethod.GET)
	public String getAddGrades(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorAddGrades";
	}

}
