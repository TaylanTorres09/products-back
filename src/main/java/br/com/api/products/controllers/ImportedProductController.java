package br.com.api.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.ImportedProduct;
import br.com.api.products.service.ImportedProductService;

@RestController
@RequestMapping("/products/imported")
public class ImportedProductController {
    
    @Autowired
    private ImportedProductService importedProductService;

    @GetMapping("/")
    public Iterable<ImportedProduct> listAll() {
        return importedProductService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@RequestBody ImportedProduct product) {
        return importedProductService.registerProduct(product);
    }

}
