package br.com.api.products.models;


import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "imported_products")
@Getter
@Setter
public class ImportedProduct extends Product {
    
    @NotNull(message = "Taxa obrigatória")
    private Double customsFee;
   
}