package com.luv2code.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;

    public ProductCategory() {
        super();
    }
}
