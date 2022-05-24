package com.portfolio.dmansuclal.repository;

import java.util.Optional;

import com.portfolio.dmansuclal.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Users
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUsername(String username);
    
}
