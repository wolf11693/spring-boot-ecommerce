package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        final HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE};

        // disable HTTP methods POST, PUT, PATCH, DELETE for Product domain
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

        // disable HTTP methods POST, PUT, PATCH, DELETE for ProductCategory domain
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

        this.exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Metamodel metamodel = this.entityManager.getMetamodel();
        Set<EntityType<?>> jpaEntities = metamodel.getEntities();

        List<Class> entityClassList = jpaEntities.stream()
                                                .map( entity -> {
                                                    Class<?> entityClass = entity.getJavaType();
                                                    return  entityClass;
                                                })
                                                .collect(Collectors.toList());

        Class[] domainTypes = entityClassList.toArray(new Class[entityClassList.size()]);
        config.exposeIdsFor(domainTypes);
    }
}
