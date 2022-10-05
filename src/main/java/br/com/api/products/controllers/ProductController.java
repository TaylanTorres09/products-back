package br.com.api.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<?> registerProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return productService.registerProduct(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable String id) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

}
