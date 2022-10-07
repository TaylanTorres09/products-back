package br.com.api.products.payload.response;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserInfoResponse {
    
    private String id;
    private String name;
    private String email;
    private List<String> roles;

    public UserInfoResponse(String id, String name, String email, List<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

}
