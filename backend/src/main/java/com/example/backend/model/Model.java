package com.example.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer yearRelease;

    public Model() {
    }

    public Model(Long id, String name, Integer yearRelease) {
        this.id = id;
        this.name = name;
        this.yearRelease = yearRelease;
    }
}
