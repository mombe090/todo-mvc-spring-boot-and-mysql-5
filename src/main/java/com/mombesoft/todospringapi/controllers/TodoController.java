package com.mombesoft.todospringapi.controllers;

import com.mombesoft.todospringapi.entities.Todo;
import com.mombesoft.todospringapi.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
@RequestMapping("todos")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;
    @GetMapping
    List<Todo> index() {
        return  this.todoRepository.findAll();
    }

    @PostMapping
    Todo store(@RequestBody Todo todo) {
       return this.todoRepository.save(todo);
    }

    @GetMapping("{id}")
    Todo show(@PathVariable int id) {
        return  this.todoRepository.findById(id);
    }

    @PutMapping("{id}")
    Todo update(@RequestBody Todo todo) {
        return  this.todoRepository.save(todo);
    }

    @DeleteMapping("{id}")
    Todo destroy(@PathVariable int id) {
       Todo todo = todoRepository.findById(id);
        this.todoRepository.delete(todo);
        return  todo;
    }

    @DeleteMapping("all")
    String destroyAll() {
        this.todoRepository.deleteAll();
        return  "Toutes les donnée ont été supprimé avec succès.";
    }
}
