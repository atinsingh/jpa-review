package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.Review;
import io.pragra.jpareview.entity.User;
import io.pragra.jpareview.repo.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final UserService service;
    private final ReviewRepo repo;

    public Review createReview(Review review, long userId){
        Optional<User> userOptional = service.getById(userId);
        Review out = null;
        if (userOptional.isPresent()) {
            out =  repo.save(review);
            User user = userOptional.get();
            user.getReviews().add(out);
            service.updateUser(user);
        }
        return out;

    }

    public Review updateReview(Review review){
        return repo.save(review);
    }

    public List<Review> getAll() {
        return repo.findAll();
    }

    public Optional<Review> getById(long id) {
        return repo.findById(id);
    }
}
