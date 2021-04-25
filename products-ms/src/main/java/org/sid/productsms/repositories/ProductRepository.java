package org.sid.productsms.repositories;

import org.sid.productsms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {

    @RestResource(path="/byName")
    public List<Product> findByNameContains(@Param("kw") String kw);
    @RestResource(path="/byPrice")
    public List<Product> findByPriceGreaterThan(@Param("minPrice") double value);

}




