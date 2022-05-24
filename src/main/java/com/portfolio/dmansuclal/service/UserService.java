package com.portfolio.dmansuclal.service;

import com.portfolio.dmansuclal.model.User;

/**
 * Interface for users
 */
public interface UserService {

    /**
     * Saves details input by user in the register form onto the database
     * @param user New user to be added to database
     */
    void registerUser(User user);

}
