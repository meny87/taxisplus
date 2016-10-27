package com.menulabs.taxisplus.services;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.menulabs.taxisplus.domain.User;
import com.menulabs.taxisplus.domain.dto.UserCreateForm;
import com.menulabs.taxisplus.repositories.UserRepository;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;


	public Optional<User> getUserById(long id) {
		LOGGER.debug("Getting user={}", id);
		return Optional.ofNullable(userRepository.findOne(id));
	}

	public Optional<User> getUserByEmail(String email) {
		LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

	public Collection<User> getAllUsers() {
		LOGGER.debug("Getting all users");
		return userRepository.findAll(new Sort("email"));
	}

	public User create(UserCreateForm form) {
		User user = new User();
		user.setEmail(form.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		user.setRole(form.getRole());
		return userRepository.save(user);
	}

}
