package com.daniel96a.todos.mapper;

import com.daniel96a.todos.entity.Todo;
import com.daniel96a.todos.dto.TodoDTO;

import java.util.List;

public class TodoMapper {
    public static List<TodoDTO> map(List<Todo> todos) {
        return todos.stream().map(todo -> TodoDTO.builder()
                        .id(todo.getId())
                        .title(todo.getTitle())
                        .isCompleted(todo.getIsCompleted())
                        .category(todo.getTitle())
                        .createdAt(todo.getCreatedAt())
                        .updatedAt(todo.getUpdatedAt())
                        .build())
                .toList();
    }

    public static TodoDTO map(Todo todo) {
        return TodoDTO.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .category(todo.getTitle())
                .isCompleted(todo.getIsCompleted())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}