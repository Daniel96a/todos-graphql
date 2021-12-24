package com.daniel96a.todos.service;
import com.daniel96a.todos.entity.Todo;

import java.util.List;


public interface TodoService {
    List<Todo> fetchAll();
    Todo fetchTodoById(Long id);
    Todo addTodo(String title, String category);
    void deleteTodo(Long id);
    Todo editTodo(Long id, String title, String category, Boolean isCompleted);
}
