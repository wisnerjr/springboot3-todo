package com.springboot.todo.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Size;

public class Todo {
	private int id;
	private String username;
	@Size(min = 5, message = "Enter at least 5 Characters")
	private String description;
//	@Future(message = "Enter a future date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate targetDate;
	private boolean done;

	public Todo() {
	}

	public Todo(int id, String username, String description, LocalDate targetDate) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = false;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, description=%s, targetDate=%s, isDone=%s]", id, username, description, targetDate, done);
	}

}
