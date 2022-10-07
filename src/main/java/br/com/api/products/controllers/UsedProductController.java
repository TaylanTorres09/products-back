package br.com.api.products.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.UsedProduct;
import br.com.api.products.service.UsedProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products/used")
public class UsedProductController {
    
    @Autowired
    private UsedProductService usedProductService;

    @GetMapping("/")
    public Iterable<UsedProduct> listAll() {
        return usedProductService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@Valid @RequestBody UsedProduct product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<FieldError>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        return usedProductService.registerProduct(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody UsedProduct product, @PathVariable String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<FieldError>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        product.setId(id);
        return usedProductService.updateProduct(product);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable String id) {
        return usedProductService.deleteProduct(id);
    }

}
