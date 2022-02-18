package com.example.backend.repository;

import com.example.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT * " +
            "FROM Review r " +
            "WHERE r.user.username = :username",
            nativeQuery = true)
    List<Review> findAllReviewsByUser_Username(String username);
}
