package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        final HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE};

        // disable HTTP methods POST, PUT, PATCH, DELETE for Product domain
        config.getExposureConfiguration()
                    .forDomainType(Product.class)
                    .withItemExposure( (metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods) )
                    .withCollectionExposure( (metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods) );

        // disable HTTP methods POST, PUT, PATCH, DELETE for ProductCategory domain
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure( (metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods) )
                .withCollectionExposure( (metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods) );
    }

}