package io.pragra.jpareview.service;
import io.pragra.jpareview.entity.Product;
import io.pragra.jpareview.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product createProduct(Product product){
        return this.productRepo.save(product);
    }

    public Product updateProduct(Product product){
        return this.productRepo.save(product);
    }

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return this.productRepo.findById(id);
    }

    public void deleteProdById(Long id){
        this.productRepo.deleteById(id);
    }

}
