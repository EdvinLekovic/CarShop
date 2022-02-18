package com.example.backend.service.impl;

import com.example.backend.model.*;
import com.example.backend.model.dto.ReviewDto;
import com.example.backend.model.dto.UsernameDto;
import com.example.backend.repository.ReviewRepository;
import com.example.backend.service.ReviewService;
import com.example.backend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }

    @Override
    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllReviewsByUsername(UsernameDto usernameDto) {
        return reviewRepository.findAllReviewsByUser_Username(usernameDto.getUsername());
    }

    @Override
    public Optional<Review> addReview(ReviewDto reviewDto) throws JsonProcessingException {
        User user = userService.findUserByUsername(reviewDto.getUsername()).orElseThrow();
        ObjectMapper mapper = new ObjectMapper();
        Brand brand = mapper.readValue(reviewDto.getBrand(), Brand.class);
        Model model = mapper.readValue(reviewDto.getModel(), Model.class);
        Long rating = Long.parseLong(reviewDto.getRating());
        Image image = null;
        try {
            image = new Image(reviewDto.getImage().getOriginalFilename(), reviewDto.getImage().getContentType(), reviewDto.getImage().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Review review = new Review(user,
                model,
                brand,
                rating,
                reviewDto.getDescription(),
                image);

        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public Optional<Review> editReview(ReviewDto reviewDto, Long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.setDescription(reviewDto.getDescription());
        review.setRating(Long.parseLong(reviewDto.getRating()));

        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public void deleteReview(Long id) {

    }

    @Override
    public byte[] getImage(Long id) {
        return reviewRepository.findById(id).orElseThrow().getImage().getData();
    }
}
