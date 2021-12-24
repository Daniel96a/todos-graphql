package com.daniel96a.todos.repository;

import com.daniel96a.todos.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findTodoById(Long Long);
    @Transactional
    void deleteTodoById(Long Long);
}
