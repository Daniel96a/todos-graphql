package com.daniel96a.todos.service;

import com.daniel96a.todos.entity.Todo;
import com.daniel96a.todos.repository.TodoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBTodoService implements TodoService {
    private final TodoRepository todoRepository;

    public DBTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> fetchAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo fetchTodoById(Long id) {
        return todoRepository.findTodoById(id);
    }

    @Override
    public Todo addTodo(String title, String category) {
        Todo newTodo = new Todo();
        newTodo.setTitle(title);
        newTodo.setCategory(category);
        return todoRepository.save(newTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteTodoById(id);
    }

    @Override
    public Todo editTodo(Long id, String title, String category, Boolean isCompleted) {
        Todo todo = todoRepository.findTodoById(id);
        if(isCompleted != null){
            todo.setIsCompleted(isCompleted);
        }
        if( title != null){
            todo.setTitle(title);
        }
        if(category != null){
            todo.setCategory(category);
        }
        return todoRepository.save(todo);
    }
}
