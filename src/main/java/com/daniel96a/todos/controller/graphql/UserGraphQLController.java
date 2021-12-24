package com.daniel96a.todos.controller.graphql;

import com.daniel96a.todos.dto.TodoDTO;
import com.daniel96a.todos.entity.Todo;
import com.daniel96a.todos.mapper.TodoMapper;
import com.daniel96a.todos.service.TodoService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class UserGraphQLController {
    private final TodoService todoService;

    public UserGraphQLController(TodoService todoService) {
        this.todoService = todoService;
    }

    @QueryMapping
    List<TodoDTO> todos (){
        List<Todo> todos = todoService.fetchAll();
        return TodoMapper.map(todos);
    }

    @QueryMapping
    TodoDTO todoById(@Argument Long id){
        Todo user = todoService.fetchTodoById(id);
        return TodoMapper.map(user);
    }

    @MutationMapping
    TodoDTO addTodo(@Argument String title, @Argument String category){
        Todo todo = todoService.addTodo(title,category);
        return TodoMapper.map(todo);
    }

    @MutationMapping
    TodoDTO editTodo(@Argument Long id,@Argument String title, @Argument String category, @Argument Boolean isCompleted){
        Todo todo = todoService.editTodo(id,title,category,isCompleted);
        return TodoMapper.map(todo);
    }

    @MutationMapping
    TodoDTO deleteTodo(@Argument Long id){
            todoService.deleteTodo(id);
        System.out.println(TodoDTO.builder().id(id).build().getId());
        return TodoDTO.builder().id(id).build();
    }
}
