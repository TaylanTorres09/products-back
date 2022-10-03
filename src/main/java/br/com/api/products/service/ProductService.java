package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.products.models.Product;
import br.com.api.products.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    // Method list all products
    public Iterable<Product> listAll() {
        return productRepository.findAll();
    }

}
