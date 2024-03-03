package com.springboot.todo.models;

public class Todo {
	private int id;
	private String user;
	private String desc;
	private String targetDate;
	private boolean isDone;

	public Todo() {
	}

	public Todo(int id, String user, String desc, String targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getDesc() {
		return desc;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id, user, desc, targetDate,
				isDone);
	}

}
