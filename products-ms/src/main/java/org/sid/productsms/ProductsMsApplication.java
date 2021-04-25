package org.sid.productsms;

import org.sid.productsms.entities.Product;
import org.sid.productsms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsMsApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(ProductsMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"computer",20000,5));
        productRepository.save(new Product(null,"printer",450,15));
        productRepository.save(new Product(null,"smartphone",2000,35));
        productRepository.findAll().forEach(p ->{
            System.out.println(p.getName());} );

    }
}


