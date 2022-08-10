package io.pragra.jpareview.api;

import io.pragra.jpareview.entity.Product;
import io.pragra.jpareview.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService service;


    // Create product
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product)
    {
        return this.service.createProduct(product);
    }

    // Update Product
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product)
    {
        return this.service.updateProduct(product);
    }

    // Get all
    @GetMapping("/product")
    public List<Product> getAllProducts()
    {
        return this.service.getAllProducts();
    }

    // Find by id
    @GetMapping("/product/{id}")
    public Optional<Product> findById(@PathVariable Long id)
    {
        return this.service.getById(id);

    }
    // Delete by id
    @DeleteMapping("/product/id")
    public void deleteById(@PathVariable Long id)
    {
        this.service.deleteById(id);
    }
}
