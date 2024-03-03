package com.springboot.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.todo.models.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();

	public List<Todo> findByUsername(String username) {
		return todos;
	}

}
