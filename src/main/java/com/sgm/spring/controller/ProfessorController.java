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
import com.sgm.spring.model.User;
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

	@RequestMapping(value = "/professor/deleteGroup", method = RequestMethod.GET)
	public String getDeleteGroup(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorDeleteGroup";
	}

	@RequestMapping(value = "/professor/deleteGroup", method = RequestMethod.POST)
	public @ResponseBody JsonResponse deleteGroup(@RequestParam(value = "groupID") Long groupID) {
		try {
			professorService.deleteGroup(groupID);
			return new JsonResponse("Successfully deleted group", true);
		} catch (Exception ex) {
			return new JsonResponse(ex.getMessage(), false);
		}
	}

	@RequestMapping(value = "/professor/updateGroup", method = RequestMethod.GET)
	public String getUpdateGroup(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorUpdateGroup";
	}

	@RequestMapping(value = "/professor/updateGroup", method = RequestMethod.POST)
	public @ResponseBody JsonResponse updateGroup(@RequestParam(value = "groupID") Long groupID,
			@RequestParam(value = "newGroupTitle") String newGroupTitle) {
		try {
			professorService.updateStudentGroup(groupID, newGroupTitle);
			return new JsonResponse("Successfully updated group", true);
		} catch (Exception ex) {
			return new JsonResponse(ex.getMessage(), false);
		}
	}

	@RequestMapping(value = "/professor/addStudentsToGroup", method = RequestMethod.GET)
	public String addStudentsToGroup(Model model) {
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

	@RequestMapping(value = "/professor/viewStudentsInGroup", method = RequestMethod.GET)
	public String viewStudentsInGroup(Model model) {
		List<Faculty> facultys = professorService.getFacultys();
		model.addAttribute("facultys", facultys);
		return "professor/professorViewStudentsInGroup";
	}

	@RequestMapping(value = "/professor/viewStudentsInGroup", method = RequestMethod.POST)
	public @ResponseBody List<User> getStudentsInGroup(@RequestParam(value = "selectedGroupID") Long selectedGroupID) {
		return professorService.getStudentsInGroup(selectedGroupID);
	}

	@RequestMapping(value = "/professor/removeStudentsFromGroup", method = RequestMethod.POST)
	public @ResponseBody JsonResponse removeStudentsFromGroup(
			@RequestParam(value = "selectedGroupID") Long selectedGroupID,
			@RequestParam(value = "selectedStudentID") Long selectedStudentID) {
		try {
			professorService.removeStudentFromGroup(selectedGroupID, selectedStudentID);
			return new JsonResponse("Successfully removed student from group", true);
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

	@RequestMapping(value = "/professor/viewGrades/updateCurrentGrades", method = RequestMethod.POST)
	public @ResponseBody String updateStudentGrades(@RequestParam(value = "selectedGradesID") Long selectedGradesID,
			@RequestParam(value = "changedTitle") String changedTitle,
			@RequestParam(value = "changedDescription") String changedDescription,
			@RequestParam(value = "changedGrade") Long changedGrade) {
		List<Grade> thisGrade = professorService.getCurrentGrade(selectedGradesID);
		professorService.updateGrade(thisGrade, changedTitle, changedDescription, changedGrade);
		return "Successfully updated grades!";

	}

	// delete grade
	@RequestMapping(value = "/professor/deleteStudentGrades", method = RequestMethod.POST)
	public @ResponseBody JsonResponse deleteStudentGrades(
			@RequestParam(value = "selectedGradesID") Long selectedGradesID) {
		professorService.deleteStudentGrades(selectedGradesID);
		return new JsonResponse("Successfully deleted grades!", true);
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
			@RequestParam(value = "selectedCourse") String selectedCourseID, Model model, Principal principal) {
		String userName = principal.getName();
		List<StudentGroup> groups = professorService.getStudentGroup(selectedFacultyTitle, selectedCourseID,
				selectedSubjectTitle, userName);
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

	@RequestMapping(value = "/professor/viewGrades/getAllGrades", method = RequestMethod.GET)
	public @ResponseBody List<Grade> getGrades(@RequestParam(value = "selectedGroupID") Long selectedGroupID,
			@RequestParam(value = "selectedTaskID") Long selectedTaskID) {
		List<Grade> grades = professorService.getGrades(selectedGroupID, selectedTaskID);
		return grades;
	}

	@RequestMapping(value = "/professor/viewGrades/updateGrades", method = RequestMethod.GET)
	public String getCurrentGrade(@RequestParam(value = "selectedGradesID") Long selectedGrade, Model model) {
		List<Grade> grade = professorService.getCurrentGrade(selectedGrade);
		model.addAttribute("grade", grade);
		return "professor/professorUpdateGarde";
	}

	@RequestMapping(value = "/professor/viewGrades/getGrades", method = RequestMethod.GET)
	public String getGrades(Model model, @RequestParam(value = "selectedGroupID") Long selectedGroupID,
			@RequestParam(value = "selectedTaskID") Long selectedTaskID) {
		List<Grade> grades = professorService.getGrades(selectedGroupID, selectedTaskID);
		model.addAttribute("studentGrades", grades);
		return "professor/professorViewStudentGrades";
	}

	@RequestMapping(value = "/professor/viewGrades/averageGrade", method = RequestMethod.GET)
	public @ResponseBody List<Double> getStudentAverageGrade(
			@RequestParam(value = "selectedGroupID") Long selectedGroupID,
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

	@RequestMapping(value = "/professor/updateGardes", method = RequestMethod.GET)
	public String getCurrentGrade(Model model) {
		// Grade grade = professorService.getCurrentGrade(selectedGrade);
		// model.addAttribute("grade", grade);
		return "professor/professorUpdateGarde";
	}

}
