package com.portfolio.dmansuclal.service;

import java.util.Optional;

import com.portfolio.dmansuclal.model.User;
import com.portfolio.dmansuclal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow( () -> new UsernameNotFoundException("User not found with that username"));
		return user.map(IUserDetails::new).get();
    }
}
