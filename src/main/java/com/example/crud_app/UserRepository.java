package com.example.crud_app;

import org.springframework.data.repository.CrudRepository;

import com.example.crud_app.models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, String> {

}