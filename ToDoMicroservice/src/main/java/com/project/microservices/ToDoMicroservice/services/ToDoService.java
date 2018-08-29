package com.project.microservices.ToDoMicroservice.services;

import com.project.microservices.ToDoMicroservice.entities.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> getToDos(String email);

    ToDo addToDo(ToDo toDo);

    void deleteToDo(Integer id);
}

