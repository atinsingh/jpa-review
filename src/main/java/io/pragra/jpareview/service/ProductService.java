package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.Product;
import io.pragra.jpareview.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepo productRepo;

    // Create product
    public Product createProduct(Product product)
    {
        if(product.getProductSku() == null){
            Random random =  new Random();
            Long productSku = random.nextLong();
            product.setProductSku(productSku);
        }
        System.out.println(product.getProductSku());
        return this.productRepo.save(product);

    }

    // Update Product
    public Product updateProduct(Product product)
    {
        return this.productRepo.save(product);
    }

    // Get all
    public List<Product> getAllProducts()
    {
        return this.productRepo.findAll();
    }

    // Find by id
    public Optional<Product> getById(Long id)
    {
        return this.productRepo.findById(id);

    }

    // Delete by id
    public void deleteById(Long id)
    {
        this.productRepo.deleteById(id);
    }
}
