package com.springboot.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.todo.models.Todo;
import com.springboot.todo.security.AuthorizationService;
import com.springboot.todo.services.TodoService;
import jakarta.validation.Valid;

@Controller
public class TodoController {
	private final AuthorizationService authorizationService;
	private final TodoService todoService;

	public TodoController(final AuthorizationService authorizationService, final TodoService todoService) {
		this.authorizationService = authorizationService;
		this.todoService = todoService;
	}

	@GetMapping("/list-todos")
	public String listTodosPage(ModelMap model) {
//		var username = (String)model.get("name");
		var username = authorizationService.getLoggedInUserName();
		model.put("todos", todoService.findByUsername(username));
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
//		var username = (String)model.get("name");
		var username = authorizationService.getLoggedInUserName();
		todoService.addTodo(todo.getDescription(), username, todo.getTargetDate());
		return "redirect:/list-todos";
	}

	@GetMapping("/update-todo")
	public String updateTodoPage(@RequestParam int id, ModelMap model) {
		var todo = todoService.findById(id);
		if (todo.isPresent()) {
			model.addAttribute("todo", todo.get());
			return "todo";
		}
		model.put("errorMessage", "Todo not found");
		return "redirect:/list-todos";
	}

	@PostMapping("/update-todo")
	public  String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUsername((String)model.get("name"));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}

	@GetMapping("/delete-todo")
	public String deleteTodoPage(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
}
