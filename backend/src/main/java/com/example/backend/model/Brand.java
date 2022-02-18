package com.example.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Brand {

    @Id
    private String name;

    private Date dateFounded;

    private String headquarters;

    private String website;

    @OneToMany
    private List<Model> models;

    public Brand(String name, Date dateFounded, String headquarters, String website, List<Model> models) {
        this.name = name;
        this.dateFounded = dateFounded;
        this.headquarters = headquarters;
        this.website = website;
        this.models = models;
    }

    public Brand() {
    }
}
