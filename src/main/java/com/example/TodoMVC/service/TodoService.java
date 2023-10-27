package com.example.TodoMVC.service;

import com.example.TodoMVC.model.Todo;
import com.example.TodoMVC.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepo repo;

    public List<Todo> getTodo() {
        return repo.getTodoList();
    }


    public String addTodo(Todo mytodo) {
        repo.getTodoList().add(mytodo);
        return "Added";
    }

    public String updateTodo(Integer todoId,Boolean status) {
        for(Todo ele : repo.getTodoList()){
            if(ele.getTodoId().equals(todoId)){
                ele.setTodoStatus(status);
                return "Updated Todo";
            }
        }
        return "Invalid Id";

    }

    public String deleteTodo(Integer todoId) {
        for(Todo ele : repo.getTodoList()){
            if(ele.getTodoId().equals(todoId)){
                repo.getTodoList().remove(ele);
                return "delete todo";
            }
        }

        return "Invalid Id";
    }

    public List<Todo> getAllUndoneTodos() {
        ArrayList<Todo> undoneTodos = new ArrayList<>();
        for(Todo ele : repo.getTodoList()){
            if(!ele.isTodoStatus()){
                undoneTodos.add(ele);
            }
        }

        return undoneTodos;
    }

    public String multipleTodoAdd(List<Todo> todo) {
        //repo.getTodoList().addAll(todo);
        for(Todo ele : todo){
            repo.getTodoList().add(ele);
        }
        return "todos Added";
    }


    @DeleteMapping("delete/multiple/todos")
    public List<Todo> deleteMultipleTodos(List<Integer> todoId) {
       for(Integer num : todoId){
           for(int i = 0; i < repo.getTodoList().size(); i ++){
               if(num.equals(repo.getTodoList().get(i).getTodoId())){
                   repo.getTodoList().remove(repo.getTodoList().get(i));
               }
           }
       }

        return repo.getTodoList();
    }
}
