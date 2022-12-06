package br.com.api.products.controllers;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.models.User;
import br.com.api.products.payload.request.LoginRequest;
import br.com.api.products.payload.request.SignUpRequest;
import br.com.api.products.payload.response.JwtResponse;
import br.com.api.products.security.jwt.JwtUtils;
import br.com.api.products.security.services.UserDetailsImpl;
import br.com.api.products.service.UserService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/")
    public Iterable<User> listAll() {
        return userService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest signUpRequest) {
        return userService.register(signUpRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt, 
                                                        userDetails.getId(), 
                                                        userDetails.getUsername(), 
                                                        userDetails.getEmail(), 
                                                        roles));
    }

    // @PostMapping("/logout")
    // public ResponseEntity<?> logoutUser() {
    //     ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    //     messageResponse.setMessage("Você fez logout");
    //     return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
    //         .body(messageResponse);
    // }

}
