package io.pragra.jpareview.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "TABLE_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String brandName;

    private String category;

    @OneToOne
    private PriceDetail priceDetails;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
