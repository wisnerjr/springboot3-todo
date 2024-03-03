package com.springboot.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.todo.security.AuthenticationService;

@Controller
@SessionAttributes("username")
public class LoginController {

	private final AuthenticationService authenticationService;

	public LoginController(final AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String postLoginPage(@RequestParam String username, @RequestParam String password, ModelMap model) {
		if (authenticationService.authenticate(username, password)) {
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials. Please try again!");
		return "login";
	}

}
