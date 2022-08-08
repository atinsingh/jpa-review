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
    private final ProductService productService;
    private final ReviewRepo repo;

    public Review createReview(Review review, long userId,long prodId){
        Optional<User> userOptional = service.getById(userId);
        Optional<Product> product = productService.getProductById(prodId);
        Review out = null;
        if (userOptional.isPresent() && product.isPresent()) {
            out =  repo.save(review);
            User user = userOptional.get();
            user.getReviews().add(out);
            Product prod = product.get();
            Optional<Review> any = prod.getReviews().stream().findAny();
            service.updateUser(user);
            productService.updateProduct(prod);
        }
        return out;

    }

    public Review updateReview(Review review, long userId,long prodId){
        Optional<User> userOptional = service.getById(userId);
        Optional<Product> product = productService.getProductById(prodId);
        Review out = null;
        if (userOptional.isPresent() && product.isPresent()) {
            out =  repo.save(review);
            User user = userOptional.get();
            user.getReviews().add(out);
            Product prod = product.get();
            Optional<Review> any = prod.getReviews().stream().findAny();
            service.updateUser(user);
            productService.updateProduct(prod);
        }
        return out;
    }

    public List<Review> getAll() {
        return repo.findAll();
    }

    public Optional<Review> getById(long id) {
        return repo.findById(id);
    }
}
