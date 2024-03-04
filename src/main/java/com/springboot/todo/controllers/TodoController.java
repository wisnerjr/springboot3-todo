package com.springboot.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.todo.models.Todo;
import com.springboot.todo.services.TodoService;
import jakarta.validation.Valid;

@Controller
public class TodoController {
	private final TodoService todoService;

	public TodoController(final TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/list-todos")
	public String listTodosPage(ModelMap model) {
		model.put("todos", todoService.findByUsername("admin"));
		return "listTodos";
	}

	@GetMapping("/add-todo")
	public String addTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@PostMapping("/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		var username = (String)model.get("name");
		todoService.addTodo(todo.getDescription(), username, todo.getTargetDate());
		return "redirect:/list-todos";
	}
}
