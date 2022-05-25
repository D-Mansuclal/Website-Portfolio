package com.portfolio.dmansuclal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 5, max = 10, message = "Username must be between 5 to 10 characters")
    private String username;

    @Email(message = "Email not valid.")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,2000}$",
    message = "Password must have at least one digit, lowercase, uppercase, and special character.")
    private String password;

    @Transient
    private String confirmPassword;

    @NotBlank(message = "First Name cannot be blank")
    @Size(max = 20, message = "First Name cannot exceed 20 characters")
    private String firstname;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(max = 20, message = "Last Name cannot exceed 20 characters")
    private String lastname;

    private String roles;
}
