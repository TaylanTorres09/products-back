package br.com.api.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.products.models.User;
import br.com.api.products.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method list all users
    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    // Register users
    public ResponseEntity<?> register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

}
