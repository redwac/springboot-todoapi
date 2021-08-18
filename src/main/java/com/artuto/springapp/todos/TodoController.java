package com.artuto.springapp.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"","/"})
    public List<Todo>  listTodos(){
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id){
        return todoService.getById(id);
    }

    @PostMapping(value = {"","/"})
    public Todo createNewTodo(@RequestBody Todo todo){

        return todoService.save(todo);
    }

    @DeleteMapping(value = {"{id}"})
    public void deleteToto(@PathVariable String id) {
        todoService.delete(id) ;
    }
}
