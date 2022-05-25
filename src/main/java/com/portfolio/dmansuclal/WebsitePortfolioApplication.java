package com.portfolio.dmansuclal;

import com.portfolio.dmansuclal.model.User;
import com.portfolio.dmansuclal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebsitePortfolioApplication implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder pEncoder;

	public static void main(String[] args) {
		SpringApplication.run(WebsitePortfolioApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		User user = new User();
		user.setUsername("admin");
		user.setPassword(pEncoder.encode("TestPassword,33"));
		user.setFirstname("John");
		user.setLastname("Smith");
		user.setEmail("john.smith@examplemail.com");
		user.setRoles("ADMIN");
		userRepository.save(user);
	}

}
