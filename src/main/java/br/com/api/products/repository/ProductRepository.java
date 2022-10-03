package br.com.api.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.products.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    
}
