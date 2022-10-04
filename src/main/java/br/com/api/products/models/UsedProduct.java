package br.com.api.products.models;


import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "used_products")
@Getter
@Setter
public class UsedProduct extends Product {
    
    private Date manufactureDate;
   
}