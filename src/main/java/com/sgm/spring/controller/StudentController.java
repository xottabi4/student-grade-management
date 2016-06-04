package com.sgm.spring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sgm.spring.model.AllGroups;
import com.sgm.spring.model.Faculty;
import com.sgm.spring.model.Grade;
import com.sgm.spring.model.StudentGroup;
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
	
	@RequestMapping(value = "/student/viewSubjects", method = RequestMethod.GET)
	public String getProfessors(Model model) {
		List<Faculty> facultys = studentService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "student/student_subjects";
	}
	
	
	
	@RequestMapping(value = "/student/viewAverageGrades", method = RequestMethod.GET)
	public String getCreateGroup(Model model) {
		List<Faculty> facultys = studentService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "student/studentAverageGrade";
	}

	@RequestMapping(value = "/student/viewGrades", method = RequestMethod.GET)
	public String getFacultys(Model model) {
		List<Faculty> facultys = studentService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "student/studentViewGrades";
	}
	

	@RequestMapping(value = "/student/viewGroup/viewCourses", method = RequestMethod.GET)
	public String viewCourses(Model model) {
		return "student/studentViewCourses";
	}
	
	// get subjects controller with post
		@RequestMapping(value = "/student/viewGroup/viewSubjects", method = RequestMethod.POST)
		public String getViewSubjects(@RequestParam(value = "selectedFaculty") String selectedFacultyTitle, Model model) {
			List<UniveristySubject> subjects = studentService.getSubjects(selectedFacultyTitle);
			model.addAttribute("subjects", subjects);
			return "student/studentViewSubjects";
		}

		// get group controller with post
		@RequestMapping(value = "/student/viewGroup/viewGroups", method = RequestMethod.POST)
		public String getViewGroups(@RequestParam(value = "selectedFaculty") String selectedFacultyTitle,
				@RequestParam(value = "selectedSubject") String selectedSubjectTitle,
				@RequestParam(value = "selectedCourse") String selectedCourseID, Model model) {
			List<StudentGroup> groups = studentService.getStudentGroups(selectedFacultyTitle, selectedCourseID,
					selectedSubjectTitle);
			model.addAttribute("groups", groups);
			return "student/studentViewGroups";
		}

		// get tasks controller with post
		@RequestMapping(value = "/student/viewGroup/viewTasks", method = RequestMethod.POST)
		public String getViewTasks(Model model ) {
			List<Task> tasks = studentService.getTasks();
			model.addAttribute("tasks", tasks);
			return "student/studentViewTasks";
		}
		
		@RequestMapping(value = "/student/viewGroup/viewAverageGrades", method = RequestMethod.GET)
		public String getViewTasks(Model model,@RequestParam(value = "selectedGroupID") Long selectedGroupID,
		 Long selectedTaskID,Principal principal ) {
			List<Task> tasks = studentService.getTasks();
			List<Double> averageGrade = studentService.getAllAverageGrades(principal.getName(), selectedGroupID);
			model.addAttribute("averageGrades", averageGrade);
			model.addAttribute("tasks", tasks);
			return "student/studentViewAverageGrades";
		}
		
		@RequestMapping(value = "/student/viewGroup/getGrades", method = RequestMethod.GET)
		public @ResponseBody List<Grade> getGrades(@RequestParam(value = "selectedGroupID") Long selectedGroupID,
			@RequestParam(value = "selectedTaskID") Long selectedTaskID,Principal principal) {
			List<Grade> grades = studentService.getGrades(principal.getName(), selectedGroupID, selectedTaskID);
			return grades;
		}
		
		@RequestMapping(value = "/student/viewGroup/getProfessors", method = RequestMethod.GET)
		public @ResponseBody List<StudentGroup> getGroups(@RequestParam(value = "selectedFacultyID") Long facultyID) {
			List<StudentGroup> groups = studentService.getAllStudentGroups(facultyID);
			return groups;
		}
		
//		@RequestMapping(value = "/student/viewGrades/averageGrade", method = RequestMethod.GET)
//		public @ResponseBody List<Double> getStudentAverageGrade(@RequestParam(value = "selectedGroupID") Long selectedGroupID,
//				@RequestParam(value = "selectedTaskID") Long selectedTaskID,Principal principal ) {
//			List<Grade> grades = studentService.getGrades(principal.getName(), selectedGroupID, selectedTaskID);
//			List<Double> averageGrade = studentService.getAverageGrade(grades);
//			return averageGrade;
//		}
		@RequestMapping(value = "/student/viewGrades/averageGrade", method = RequestMethod.GET)
		public @ResponseBody List<Double> getAllStudentAverageGrade(@RequestParam(value = "selectedGroupID") Long selectedGroupID,
				@RequestParam(value = "selectedTaskID") Long selectedTaskID,Principal principal ) {
//			List<Grade> grades = studentService.getGrades(principal.getName(), selectedGroupID, selectedTaskID);
			List<Double> averageGrade = studentService.getAllAverageGrades(principal.getName(), selectedGroupID);
			
			return averageGrade;
		}

}
