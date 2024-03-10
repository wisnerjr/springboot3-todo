package com.springboot.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.todo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

	List<Todo> findByUsername(String username);

}
