package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable page);

    public Page<Product> findByCategoryCategoryNameContaining(@RequestParam("name") String categoryName, Pageable page);
}
