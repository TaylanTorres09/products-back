package br.com.api.products.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserDto {

    @NotEmpty(message = "Nome obrigatório")
    private String userName;

    @NotBlank(message = "Email obrigatório")
    private String email;

    @NotBlank(message = "Senha obrigatório")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
