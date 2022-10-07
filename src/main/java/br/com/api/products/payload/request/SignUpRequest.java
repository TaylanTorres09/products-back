package br.com.api.products.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class SignUpRequest {
    
    @NotEmpty
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 50)
    private String password;

}
