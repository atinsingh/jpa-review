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

    @PostMapping("/user/{id}/review")
    public Review createOne(@RequestBody Review review, @PathVariable long id) {
        return this.service.createReview(review, id);
    }

    @PutMapping("/user/{id}/review")
    public Review update(@RequestBody Review review, @PathVariable long id) {
        return this.service.createReview(review,id);
    }

    @GetMapping("/review")
    public List<Review> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/review/{id}")
    public Optional<Review> getAll(@PathVariable long id) {
        return this.service.getById(id);
    }

}
