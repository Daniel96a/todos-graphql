package com.daniel96a.todos.controller.rest;

import com.daniel96a.todos.dto.TodoDTO;
import com.daniel96a.todos.entity.Todo;
import com.daniel96a.todos.mapper.TodoMapper;
import com.daniel96a.todos.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    private final TodoService todoService;

    public UserController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/")
    public List<TodoDTO> getAllTodos(){
        List<Todo> todos = todoService.fetchAll();
        return  TodoMapper.map(todos);
    }

}
