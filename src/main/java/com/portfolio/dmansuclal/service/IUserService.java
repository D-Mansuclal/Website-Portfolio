package com.portfolio.dmansuclal.service;

import com.portfolio.dmansuclal.model.User;
import com.portfolio.dmansuclal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation for the UserService interface
 */
@Service
public class IUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder pEncoder;

    @Override
    public void registerUser(User user) {
        String password = user.getPassword();
        user.setPassword(pEncoder.encode(password));
        user.setRoles("USER");
        userRepository.save(user);
    }


    
}
