package br.com.api.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.Product;
import br.com.api.products.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Iterable<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@RequestBody Product product) {
        return productService.registerProduct(product);
    }

}
