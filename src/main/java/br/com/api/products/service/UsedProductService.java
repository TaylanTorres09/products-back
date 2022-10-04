package br.com.api.products.service;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.models.UsedProduct;
import br.com.api.products.repository.UsedProductRepository;

@Service
public class UsedProductService {
    
    @Autowired
    private UsedProductRepository usedProductRepository;

    // Method list all products
    public Iterable<UsedProduct> listAll() {
        return usedProductRepository.findAll();
    }

    // Method create products
    public ResponseEntity<?> registerProduct(UsedProduct product) {
        product.setManufactureDate(new Date());
        return new ResponseEntity<UsedProduct>(usedProductRepository.save(product), HttpStatus.CREATED);
    }

}
