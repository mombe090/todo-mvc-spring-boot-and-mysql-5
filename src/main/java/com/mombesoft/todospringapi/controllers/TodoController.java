package com.mombesoft.todospringapi.controllers;

import com.mombesoft.todospringapi.entities.Todo;
import com.mombesoft.todospringapi.repositories.TodoRepository;
import com.mombesoft.todospringapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
@RequestMapping("todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
     public ResponseEntity index() {
        List<Todo> todos = this.todoService.getTodos();

        if (!todos.isEmpty()) {
            return new  ResponseEntity<>(todos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new EmptyClass(), HttpStatus.OK);
        }
    }

    @PostMapping
    ResponseEntity store(@RequestBody Todo todo) {
        Todo saved = this.todoService.saveOrUpdate(todo);
        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new EmptyClass(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("{id}")
    ResponseEntity show(@PathVariable int id) {
        Todo retrieved = this.todoService.getTodo(id);
        if (retrieved != null) {
            return new ResponseEntity<>(retrieved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new EmptyClass(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    ResponseEntity update(@RequestBody Todo todo) {
        Todo retrieved = this.todoService.saveOrUpdate(todo);
        if (retrieved != null) {
            return new ResponseEntity<>(retrieved, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new EmptyClass(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    String  destroy(@PathVariable int id) {
        this.todoService.delete(id);
        return  "Deleted";
    }

    /*@DeleteMapping("all")
    String destroyAll() {
        this.todoRepository.deleteAll();
        return  "Toutes les donnée ont été supprimé avec succès.";
    }*/
}
