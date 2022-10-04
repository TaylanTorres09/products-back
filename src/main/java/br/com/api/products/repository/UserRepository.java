package br.com.api.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.api.products.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
