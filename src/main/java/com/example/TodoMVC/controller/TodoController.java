package com.example.TodoMVC.controller;

import com.example.TodoMVC.model.Todo;
import com.example.TodoMVC.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService service;

    @GetMapping("Todo")
    public List<Todo> getTodo(){
        return service.getTodo();
    }

    @PostMapping("add/todo")
    public String addTodo(@RequestBody Todo mytodo){
        return service.addTodo(mytodo);
    }

    @PutMapping("update/todo/{todoId}/{status}") public String updateTodo(@PathVariable Integer todoId,@PathVariable Boolean status){
        return service.updateTodo(todoId,status);
    }

    @DeleteMapping("delete/todo/{todoId}")
    public String deleteTodo(@PathVariable Integer todoId){
        return service.deleteTodo(todoId);
    }

    @GetMapping("undone/todos")
    public List<Todo> getAllUndoneTodos(){
        return service.getAllUndoneTodos();
    }

    @PostMapping("multiple/todo/add")
    public String multipleTodoAdd(@RequestBody List<Todo> todo){
       return service.multipleTodoAdd(todo);
    }

    @GetMapping("delete/multiple/todos")
    public List<Todo> deleteMultipleTodos(@RequestBody List<Integer> todoId){
        return service.deleteMultipleTodos(todoId);
    }






}
