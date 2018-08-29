package com.project.microservices.ToDoMicroservice.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//LOMBOK
//JPA
//VALIDATION JSR-303 -> Hibernate validator   DATA BINDING (email, name, password) -> new User(email, name, password)

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="EMAIL")
    @Getter @Setter
    @NotNull @NotBlank @NotEmpty
    private String email;

    @Column(name="NAME")
    @Getter @Setter
    @NotNull @NotBlank @NotEmpty
    private String name;

    @Column(name="PASSWORD")
    @Getter @Setter
    @NotNull @NotBlank @NotEmpty
    private String password;

    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

