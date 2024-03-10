package com.springboot.todo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.todo.security.AuthorizationService;

@Controller
@SessionAttributes("username")
public class WelcomeController {

	private final AuthorizationService authorizationService;
	public WelcomeController(final AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}
	@GetMapping("/")
	public String goToWelcomePage(ModelMap model) {
		var username = authorizationService.getLoggedInUserName();

		model.put("username", username);
		return "welcome";
	}
}
