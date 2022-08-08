package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.PriceDetails;
import io.pragra.jpareview.entity.Product;
import io.pragra.jpareview.repo.PriceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceDetailsService {
    private final PriceRepo priceRepo;

    private final ProductService productService;

    public PriceDetails createPriceDetails(PriceDetails priceDetails,Long prodId) {
        PriceDetails price = null;
        Optional<Product> prod = productService.getProductById(prodId);
        if(prod.isPresent()){
            price = this.priceRepo.save(priceDetails);
            Product product = prod.get();
            product.setPriceDetails(price);
            productService.updateProduct(product);
        }
        return price;
    }

    public PriceDetails updatePriceDetails(PriceDetails priceDetails,Long prodId) {
        PriceDetails price = null;
        Optional<Product> prod = productService.getProductById(prodId);
        if(prod.isPresent()){
            price = this.priceRepo.save(priceDetails);
            Product product = prod.get();
            product.setPriceDetails(price);
            productService.updateProduct(product);
        }
        return price;
    }

    public List<PriceDetails> getAll() {
        return this.priceRepo.findAll();
    }

    public Optional<PriceDetails> getById(long id) {
        return this.priceRepo.findById(id);
    }

    public void deleteById(long id) {
        this.priceRepo.deleteById(id);
    }

}
