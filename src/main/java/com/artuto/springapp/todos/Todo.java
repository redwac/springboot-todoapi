package com.artuto.springapp.todos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "todos")
public class Todo {

    @Id
    private String id;

    @NotNull(message = "ne doit pas etre null")
    @Size(min = 3, message = "le nombre de caractere doit etre plus q 3 c")
    private String title;

    @NotNull(message = "Description is required")
    private String description;
    private long timestamp;

    public Todo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Todo(){
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
