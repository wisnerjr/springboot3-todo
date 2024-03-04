package com.springboot.todo.models;

import jakarta.validation.constraints.Size;

public class Todo {
	private int id;
	private String user;
	@Size(min = 5, message = "Enter at least 5 Characters")
	private String description;
	private String targetDate;
	private boolean done;

	public Todo() {
	}

	public Todo(int id, String user, String description, String targetDate) {
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.done = false;
	}

	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getDescription() {
		return description;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, description=%s, targetDate=%s, isDone=%s]", id, user, description, targetDate, done);
	}

}
