package io.pragra.jpareview.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TABLE_USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, columnDefinition = "VARCHAR", length = 150)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Transient
    private String secretName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews = new java.util.ArrayList<>();

}
