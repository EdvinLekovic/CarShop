package com.example.backend.service;

import com.example.backend.model.Review;
import com.example.backend.model.dto.ReviewDto;
import com.example.backend.model.dto.UsernameDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> listAllReviews();
    List<Review> findAllReviewsByUsername(UsernameDto usernameDto);
    Optional<Review> addReview(ReviewDto reviewDto) throws JsonProcessingException;
    Optional<Review> editReview(ReviewDto reviewDto,Long id);
    void deleteReview(Long id);
    byte[] getImage(Long id);
}
