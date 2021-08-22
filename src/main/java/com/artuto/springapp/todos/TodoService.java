package com.artuto.springapp.todos;

import com.artuto.springapp.error.ConfllitException;
import com.artuto.springapp.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    @Autowired
  private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo getById(String id) {
    try {
        return todoRepository.findById(id).get();
    }catch (NoSuchElementException ex){
        throw new NotFoundException(String.format("No record with the id [%s] was found in our database", id));
    }

    }

    public Todo save(Todo todo){
        if(todoRepository.findByTitle(todo.getTitle()) != null){
            throw new ConfllitException("Another record with the same title exist");
        }
        return todoRepository.insert(todo);
    }

    public void delete(String id){
        todoRepository.deleteById(id);
    }
}
