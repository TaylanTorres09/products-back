package br.com.api.products.payload.response;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class MessageResponse {
    
    private String message;

}
