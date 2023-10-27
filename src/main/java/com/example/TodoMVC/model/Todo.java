package com.example.TodoMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Integer todoId;
    private String todoName;
    private boolean todoStatus;
}
