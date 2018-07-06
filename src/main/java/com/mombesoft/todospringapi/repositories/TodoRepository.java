package com.mombesoft.todospringapi.repositories;

import com.mombesoft.todospringapi.entities.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Override
    List<Todo> findAll();
    Todo findById(int id);
}
