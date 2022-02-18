package com.example.backend.web.rest;

import com.example.backend.model.Review;
import com.example.backend.model.dto.ReviewDto;
import com.example.backend.service.ReviewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@CrossOrigin("http://localhost:8080")
public class ReviewResource {

    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return this.reviewService.listAllReviews();
    }

    @PostMapping(value = "/add-review", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Optional<Review> addReviews(@RequestParam String username,
                                       @RequestParam String brand,
                                       @RequestParam String model,
                                       @RequestParam String rating,
                                       @RequestParam String description,
                                       @RequestParam MultipartFile image) throws JsonProcessingException {
        ReviewDto reviewDto = new ReviewDto(username,model,brand, rating, description, image);
        return this.reviewService.addReview(reviewDto);
    }

    @GetMapping(value = "/review-image/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return reviewService.getImage(id);
    }

    @DeleteMapping("/delete-review/{id}")
    public void deleteReviews(@PathVariable Long id) {
        this.reviewService.deleteReview(id);
    }
}
