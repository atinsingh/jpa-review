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
    private final ProductService productService;
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return this.productService.updateProduct(product);
    }
    @GetMapping("/product")
    public List<Product>getAllProducts(){
        return this.productService.getAllProducts();
    }
    @GetMapping("/product/{id}")
    public Optional<Product>getProductById(@PathVariable long id){
        return this.productService.getProductById(id);
    }
    @DeleteMapping("/product/{id}")
    public void DeleteProduct(@PathVariable long id){
        this.productService.deleteProductById(id);
    }

}
