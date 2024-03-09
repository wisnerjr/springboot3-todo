package com.springboot.todo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.todo.models.Todo;

@Service
public class TodoService {
	private final static List<Todo> todos = new ArrayList<>();

	public List<Todo> findByUsername(final String username) {
		return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
	}

	public Optional<Todo> findById(final int id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst();
	}

	public Todo addTodo(final String description, final String username,  final LocalDate targetDate) {
		Todo todo = new Todo(getTodoCount()+1, username, description, targetDate);
		todos.add(todo);
		return todo;
	}

	public void updateTodo(final Todo todo) {
		todos.removeIf(t -> t.getId() == todo.getId());
		todos.add(todo);
		todos.sort((t1, t2) -> t1.getId() - t2.getId());
	}

	public void deleteTodo(final int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	private int getTodoCount() {
		return todos.size();
	}

}
