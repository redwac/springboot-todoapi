package com.artuto.springapp.todos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> data = new ArrayList<>(Arrays.asList(
            new Todo(1,"first toto title","first todo description"),
            new Todo(2,"second toto title","second todo description"),
            new Todo(3,"third toto title","third s todo description"))
    ) ;

    public List<Todo> findAll() {
        return data;
    }

    public Todo getById(int id) {
        for (Todo todo : data) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public boolean save(Todo todo){
        return data.add(todo);
    }

    public void delete(int id){
        for (Todo todo : data){
            if(todo.getId()==id){
                data.remove(todo);
            }
        }
    }
}
