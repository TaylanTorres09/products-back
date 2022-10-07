package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Method create products
    public ResponseEntity<?> registerProduct(Product product) {
        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.CREATED);
    }

    // Method update products
    public ResponseEntity<?> updateProduct(Product product) {
        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
    }

    // Method delete products
    public ResponseEntity<String> deleteProduct(String id) {
        productRepository.deleteById(id);
        return new ResponseEntity<String>("Produto " + id + " removido com sucesso", HttpStatus.OK);
    }

}
