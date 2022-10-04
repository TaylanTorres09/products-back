package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.api.products.models.User;
import br.com.api.products.repository.UserRepository;

public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // Method list all users
    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    // Register users
    public ResponseEntity<?> register(User user) {
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

}
