package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.Product;
import io.pragra.jpareview.entity.User;
import io.pragra.jpareview.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private UserService service;
    private  ProductRepo productRepo;

    public Product createProduct(Product product, long id){
        Optional<User> optionalUser = this.service.getById(id);
        Product out = null;
        if(optionalUser.isPresent()){
            out = productRepo.save(product);
            User user = optionalUser.get();
            user.getAllProducts().add(out);
            service.updateUser(user);
        }
        return out;
    }

    public Product updateProduct(Product product, long id){
        return this.productRepo.save(product);
    }

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    public Optional<Product> getById(long id){
        return this.productRepo.findById(id);
    }

    public void deleteById(long id){
         this.productRepo.deleteById(id);
    }
}
