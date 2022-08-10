package io.pragra.jpareview.repo;

import io.pragra.jpareview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
