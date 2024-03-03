package com.springboot.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.todo.services.TodoService;

@Controller
public class TodoController {
	private final TodoService todoService;

	public TodoController(final TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/list-todos")
	public String listTodosPage() {
		todoService.findByUsername("in28minutes");
		return "listTodos";
	}
}
