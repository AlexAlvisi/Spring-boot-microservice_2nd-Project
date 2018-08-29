package com.project.microservices.StatisticsMicroservice.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="latest_statistics")

public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    @Getter @Setter
    private Integer Id;

    @Column(name="DESCRIPTION")
    @Getter @Setter
    @NotBlank @NotEmpty @NotNull
    private String description;

    @Column(name="DATE")
    @Getter @Setter
    private Date date;

    @Column(name="EMAIL")
    @Getter @Setter
    @NotBlank @NotEmpty @NotNull
    private String email;

    public Statistics() {
    }

    public Statistics(String description, Date date, String email) {

        this.description = description;
        this.date = date;
        this.email = email;
    }

    @PrePersist
    private void getTimeOperation(){
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }
}


