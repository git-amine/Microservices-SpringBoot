package org.sid.productsms.web;
import org.sid.productsms.entities.Product;
import org.sid.productsms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping (path="/produits")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    @GetMapping (path="/produits/search")
    public List<Product> search(@RequestParam(name="kw") String kw){
       return productRepository.findByNameContains(kw);
    }

    @GetMapping (path="/produits/searchByPrice")
    public List<Product> searchByPrice(@RequestParam(name = "price") double p){
      return productRepository.findByPriceGreaterThan(p);
    }

    @GetMapping(path = "/produits/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id){
       return productRepository.findById(id).get();
    }

    @PostMapping(path = "/produits")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping(path="/produits/{id}")
    public Product update(@RequestBody Product product,@PathVariable Long id) {
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping(path="/produits/{id}")
    public void delete(@PathVariable Long id){
        productRepository.deleteById(id);
    }

}


