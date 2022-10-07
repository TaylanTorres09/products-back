package br.com.api.products.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
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

    @NotEmpty(message = "Nome obrigatório")
    private String name;

    @NotBlank(message = "Email obrigatório")
    private String email;

    @NotBlank(message = "Senha obrigatório")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Set<Role> roles = new HashSet<>();

    public User(String userName, String name, String email, String password) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
