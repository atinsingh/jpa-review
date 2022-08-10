package io.pragra.jpareview.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String brandName;
    private int price;
    private String SKU = UUID.randomUUID().toString().split("-")[0];
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TABLE_USER_PRODUCT_REVIEW",
            joinColumns = {@JoinColumn(name = "product_id")}
    )

    private List<Review> reviews = new ArrayList<>();

    public List<Review>  getAllReviews(){
        return reviews;
    }
}
