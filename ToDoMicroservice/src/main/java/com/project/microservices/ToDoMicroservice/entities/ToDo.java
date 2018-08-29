package com.project.microservices.ToDoMicroservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="todos")

public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    @Getter @Setter
    private Integer id;

    @Column(name="DESCPRIPTION")
    @Getter @Setter
    @NotNull @NotEmpty @NotBlank
    private String description;

    @Column(name="DATE")
    @Getter @Setter
    private Date date;

    @Column(name="PRIORITY")
    @Getter @Setter
    @NotNull @NotEmpty @NotBlank
    private String priority;

    @Column(name="FK_USER")
    @Getter @Setter
    @NotNull @NotEmpty @NotBlank
    private String fkUser;

    public ToDo() {
    }

    public ToDo(Integer id, String description, Date date, String priority, String fkUser) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.priority = priority;
        this.fkUser = fkUser;
    }

    @PrePersist
    void getTimeOperation() {
        this.date = new Date();


    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }
}