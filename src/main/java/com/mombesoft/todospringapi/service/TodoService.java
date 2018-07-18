package com.mombesoft.todospringapi.service;

import com.mombesoft.todospringapi.entities.Todo;
import com.mombesoft.todospringapi.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return this.todoRepository.findAll();
    }

    public Todo getTodo(int id) {
        return this.todoRepository.findById(id);
    }

    public Todo saveOrUpdate(Todo todo) {
      return this.todoRepository.save(todo);
    }

    public String delete(int id) {
        this.todoRepository.delete(this.getTodo(id));
        return "Todo deleted well";
    }
}
