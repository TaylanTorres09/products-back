package br.com.api.products.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
public class User {
    
    @Id
    private String id;

    @NotEmpty(message = "Nome obrigatório")
    private String userName;

    @NotBlank(message = "Email obrigatório")
    private String email;

    @NotBlank(message = "Senha obrigatório")
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
