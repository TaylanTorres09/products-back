package br.com.api.products.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
public class Product {
    @Id
    private Long productId;
    private String name;
    private Double price;
   
}