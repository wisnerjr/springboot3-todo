package com.springboot.todo.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringSecurityConfiguration.class);
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

	@Bean
	public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
		try {
			httpSecurity.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated());

			httpSecurity.csrf(AbstractHttpConfigurer::disable);
			httpSecurity.headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

			httpSecurity.formLogin(formLogin -> withDefaults());
		} catch (Exception e) {
				LOGGER.info(e.getMessage());
				return null;
		}

		return httpSecurity.build();
	}

	private Function<String, String> setPasswordEncoderFunction() {
		return password -> passwordEncoder().encode(password);
	}
}
