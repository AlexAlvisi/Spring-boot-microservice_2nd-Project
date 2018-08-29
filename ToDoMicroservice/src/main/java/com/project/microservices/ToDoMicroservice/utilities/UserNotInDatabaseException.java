package com.project.microservices.ToDoMicroservice.utilities;

public class UserNotInDatabaseException extends Exception {

    public UserNotInDatabaseException(String message){
        super(message);
    }
}

