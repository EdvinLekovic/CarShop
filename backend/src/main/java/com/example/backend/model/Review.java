package com.example.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne
    private Model model;

    @OneToOne
    private Brand brand;

    private Long rating;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    private String description;

    public Review() {
    }

    public Review(User user,
                  Model model,
                  Brand brand,
                  Long rating,
                  String description,
                  Image image) {
        this.user = user;
        this.model = model;
        this.brand = brand;
        this.rating = rating;
        this.description = description;
        this.image = image;
    }
}
