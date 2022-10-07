package br.com.api.products.models;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "roles")
@Getter
@Setter
public class Role {
    
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
