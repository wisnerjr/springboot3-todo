package com.springboot.todo.security;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
				return username.equalsIgnoreCase("admin") && password.equals("admin");
		}

}
