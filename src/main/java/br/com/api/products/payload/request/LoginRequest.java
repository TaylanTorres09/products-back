package br.com.api.products.payload.request;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
