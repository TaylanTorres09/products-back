package br.com.api.products.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
public class Product {
    @Id
    private String id;

    @NotEmpty(message = "O nome do produto é obrigatório")
    @Size(min = 2, max = 100, message = "Nome tem que ter no mínimo 2 e no máximo 100 caracteres")
    private String name;

    @NotNull(message = "Preço do produto é obrigatório")
    private Double price;

    public interface ValidationGroup{}  
   
}