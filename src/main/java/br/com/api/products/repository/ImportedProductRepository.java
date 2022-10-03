package br.com.api.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.products.models.ImportedProduct;

@Repository
public interface ImportedProductRepository extends MongoRepository<ImportedProduct, String> {
    
}
