package com.springboot.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.todo.models.Todo;

@Service
public class TodoService {
	private final static List<Todo> todos = new ArrayList<>();

	public List<Todo> findByUsername(final String username) {
		return todos;
	}

	public Todo addTodo(final String description, final String username,  final String targetDate) {
		Todo todo = new Todo(getTodoCount()+1, username, description, targetDate);
		todos.add(todo);
		return todo;
	}

	private int getTodoCount() {
		return todos.size();
	}

}
