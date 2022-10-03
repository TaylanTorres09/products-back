package br.com.api.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.api.products.models.Product;


public interface ProductRepository extends MongoRepository<Product, Long> {
    
}
