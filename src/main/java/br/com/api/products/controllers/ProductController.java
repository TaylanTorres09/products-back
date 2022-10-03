package br.com.api.products.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.Product;
import br.com.api.products.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private ProductService productService;

    @GetMapping("")
    public Iterable<Product> listAll() {
        return productService.listAll();
    }

}
