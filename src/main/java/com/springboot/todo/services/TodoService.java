package com.springboot.todo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.todo.models.Todo;
import com.springboot.todo.repositories.TodoRepository;

@Service
public class TodoService {
	private final static List<Todo> todos = new ArrayList<>();

	private final TodoRepository todoRepository;

	public TodoService(final TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> findByUsername(final String username) {
		var todos = todoRepository.findByUsername(username);
		todos.sort((t1, t2) -> Math.toIntExact(t1.getId() - t2.getId()));
		return todos;
	}

	public Optional<Todo> findById(final long id) {
		return todoRepository.findById(id);
	}

	public Todo addTodo(final Todo todo, final String username) {
		todo.setUsername(username);
		return todoRepository.save(todo);
	}

	public void updateTodo(final Todo todo) {
		todoRepository.save(todo);
	}

	public void deleteTodo(final long id) {
		todoRepository.deleteById(id);
	}

	private long getTodoCount() {
		return todoRepository.count();
	}

}
