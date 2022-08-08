package io.pragra.jpareview.api;

import io.pragra.jpareview.entity.Review;
import io.pragra.jpareview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService service;

    @PostMapping("/user/{userId}/product/{prodId}/review")
    public Review createReview(@RequestBody Review review, @PathVariable long userId, @PathVariable long prodId) {
        return this.service.createReview(review, userId, prodId);
    }

    @PutMapping("/user/{userId}/product/{prodId}/review")
    public Review updateReview(@RequestBody Review review, @PathVariable long userId, @PathVariable long prodId) {
        return this.service.updateReview(review,userId,prodId);
    }

    @GetMapping("/review")
    public List<Review> getAllReviews() {
        return this.service.getAll();
    }

    @GetMapping("/review/{id}")
    public Optional<Review> getReviewById(@PathVariable long id) {
        return this.service.getById(id);
    }

}
