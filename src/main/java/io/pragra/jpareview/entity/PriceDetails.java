package io.pragra.jpareview.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PriceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double costPrice;

    private double offer;

    private double price;
}
