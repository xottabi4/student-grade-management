package com.sgm.spring.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(Model model) {

		if (hasRole("student")) {
			return "redirect:/student";
		} else if (hasRole("professor")) {
			return "redirect:/professor";
		} else {
			return "login/loginPageNew";
		}
	}

	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String professorPage(Model model, Principal principal) {
		String userName = principal.getName();
//		model.addAttribute("message", "HI PROFESOR !!!!!!!!!");
		model.addAttribute("username", userName);
		return "professor/professorMain";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentPage(Model model, Principal principal) {
		String userName = principal.getName();
		model.addAttribute("message", "HI STUDENT !!!!!!!!!");
		model.addAttribute("username", userName);
		return "student/studentMain";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "login/logoutSuccessfulPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "error/403Page";
	}

	private boolean hasRole(String role) {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		boolean hasRole = false;
		for (GrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals(role);
			if (hasRole) {
				break;
			}
		}
		return hasRole;
	}
}