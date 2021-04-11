package com.luv2code.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "UNITS_IN_STOCK")
    private Integer unitsInStock;

    @Column(name = "DATE_CREATED")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "LAST_UPDATED")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private ProductCategory category;

    public Product() {
        super();
    }
}
