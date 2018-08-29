package com.project.microservices.ToDoMicroservice.daos;

import com.project.microservices.ToDoMicroservice.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoDao extends JpaRepository<ToDo, Integer> {

    //name strategy
    List<ToDo> findByFkUser(String email);
}
