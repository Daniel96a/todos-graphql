package com.daniel96a.todos.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class TodoDTO {
    private Long id;
    private Boolean isCompleted;
    private String title;
    private String category;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
