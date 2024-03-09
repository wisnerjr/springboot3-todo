package com.springboot.todo.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(User.builder().passwordEncoder(setPasswordEncoderFunction()).username("user").password("user").authorities("USER").build());
		inMemoryUserDetailsManager.createUser(User.builder().passwordEncoder(setPasswordEncoderFunction()).username("admin").password("admin").authorities("ADMIN").build());
		return inMemoryUserDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private Function<String, String> setPasswordEncoderFunction() {
		return password -> passwordEncoder().encode(password);
	}
}
