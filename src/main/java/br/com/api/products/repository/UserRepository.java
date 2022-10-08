package br.com.api.products.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.api.products.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserName(String userName);
    
    Optional<User> findByEmail(String email);

    Boolean existsByUserName(String userName);
    
    Boolean existsByEmail(String email);
}
