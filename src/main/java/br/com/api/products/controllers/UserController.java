package br.com.api.products.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.User;
import br.com.api.products.service.UserService;
import br.com.api.products.utils.Regex;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private Regex regex;

    @GetMapping("/")
    public Iterable<User> listAll() {
        return userService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult bindingResult) {
        FieldError fieldError = bindingResult.getFieldError();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<FieldError>(fieldError, HttpStatus.BAD_REQUEST);
        }
        return userService.register(user);
    }

}
