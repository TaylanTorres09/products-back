package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.models.ImportedProduct;
import br.com.api.products.repository.ImportedProductRepository;

@Service
public class ImportedProductService {
    
    @Autowired
    private ImportedProductRepository importedProductRepository;

    // Method list all products
    public Iterable<ImportedProduct> listAll() {
        return importedProductRepository.findAll();
    }

    // Method create products
    public ResponseEntity<?> registerProduct(ImportedProduct product) {
        return new ResponseEntity<ImportedProduct>(importedProductRepository.save(product), HttpStatus.CREATED);
    }

    // Method update products
    public ResponseEntity<?> updateProduct(ImportedProduct product) {
        return new ResponseEntity<ImportedProduct>(importedProductRepository.save(product), HttpStatus.OK);
    }

    // Method delete products
    public ResponseEntity<String> deleteProduct(String id) {
        importedProductRepository.deleteById(id);
        return new ResponseEntity<String>("Produto " + id + " removido com sucesso", HttpStatus.OK);
    }


}
