package br.com.api.products.service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.products.models.Role;
import br.com.api.products.models.User;
import br.com.api.products.payload.request.SignUpRequest;
import br.com.api.products.payload.response.MessageResponse;
import br.com.api.products.repository.UserRepository;
import br.com.api.products.utils.Regex;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MessageResponse messageResponse;

    @Autowired
    private Regex regex;

    // Method list all users
    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    // Register users
    public ResponseEntity<?> register(SignUpRequest signUpRequest) {
        if (userRepository.existsByName(signUpRequest.getName())) {
            messageResponse.setMessage("Esse nome já existe");
            return new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.BAD_REQUEST);
        } else if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            messageResponse.setMessage("Este email já está em uso");
            return new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.BAD_REQUEST);
        }
        // Validate e-mail
        Pattern patternEmail = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matchEmail = patternEmail.matcher(signUpRequest.getEmail());
        // Validate Password
        Pattern patternPass = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matchPass = patternPass.matcher(signUpRequest.getPassword());

        if(!matchEmail.find()) {
            String message = regex.regexEmail();
            return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
        } else if(!matchPass.find()){
            String message = regex.regexPassowrd();
            return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
        }

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        User user = new User(signUpRequest.getName(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

}
