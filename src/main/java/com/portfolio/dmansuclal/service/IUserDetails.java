package com.portfolio.dmansuclal.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.dmansuclal.model.User;

/**
 * Custom user details class
 */
public class IUserDetails implements UserDetails{
	
	static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;

	private List<GrantedAuthority> authorities;
	
	public IUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.firstName = user.getFirstname();
		this.lastName = user.getLastname();
		this.authorities = Arrays.stream(user.getRoles().split(","))
			.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
;	}
	
	public IUserDetails() {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}