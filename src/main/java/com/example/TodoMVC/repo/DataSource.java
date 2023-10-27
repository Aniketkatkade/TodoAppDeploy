package com.example.TodoMVC.repo;

import com.example.TodoMVC.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSource {

    @Bean
    public List<Todo> getDataSource(){
        return new ArrayList<>();
    }
}
