package com.portfolio.dmansuclal.security;

import com.portfolio.dmansuclal.service.IUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Security Configuration for the application.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserDetailsService userDetailsService;

   //Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}


	//Authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().requiresChannel().anyRequest().requiresSecure().and()
		.authorizeRequests()
        .antMatchers("/").permitAll()
        .and()
		.formLogin().loginPage("/login").usernameParameter("username")
        .passwordParameter("password").permitAll()
		.defaultSuccessUrl("/")
        .and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    
}
