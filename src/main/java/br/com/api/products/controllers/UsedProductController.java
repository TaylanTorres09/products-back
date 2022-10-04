package br.com.api.products.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.UsedProduct;
import br.com.api.products.service.UsedProductService;


@RestController
@RequestMapping("/products/used")
public class UsedProductController {
    
    @Autowired
    private UsedProductService usedProductService;

    @GetMapping("/")
    public Iterable<UsedProduct> listAll() {
        return usedProductService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@RequestBody UsedProduct product) {
        return usedProductService.registerProduct(product);
    }

}
