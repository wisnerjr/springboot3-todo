package com.springboot.todo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.todo.models.Todo;

@Service
public class TodoService {
	private final static List<Todo> todos = new ArrayList<>();

	public List<Todo> findByUsername(final String username) {
		return todos;
	}

	public Optional<Todo> findById(final int id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst();
	}

	public Todo addTodo(final String description, final String username,  final String targetDate) {
		Todo todo = new Todo(getTodoCount()+1, username, description, targetDate);
		todos.add(todo);
		return todo;
	}

	public void deleteTodo(final int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	private int getTodoCount() {
		return todos.size();
	}

}
