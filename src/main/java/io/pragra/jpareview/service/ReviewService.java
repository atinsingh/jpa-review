package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.Product;
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

    private final ProductService productService;

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

    public Review createProductReview(Review reviews,Long productId)
    {
        Optional<Product> productOptional = productService.getById(productId);
        Review out1 = null;
        if(productOptional.isPresent())
        {
            out1 = repo.save(reviews);
            Product product = productOptional.get();
            product.getReviews().add(out1);
            productService.updateProduct(product);
        }
        return out1;
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
