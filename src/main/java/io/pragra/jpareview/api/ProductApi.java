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
    private ProductService service;
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product, @PathVariable long id){
        return this.service.createProduct(product, id);
    }
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product, @PathVariable long id){
        return this.service.updateProduct(product, id);
    }
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return this.service.getAllProducts();
    }
    @GetMapping("/product/{id}")
    public Optional<Product> getById(long id){
        return this.service.getById(id);
    }
    @DeleteMapping("/product/{id}")
    public void deleteById(long id){
        this.service.deleteById(id);
    }
}
