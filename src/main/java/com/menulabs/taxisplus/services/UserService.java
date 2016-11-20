package com.menulabs.taxisplus.services;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.menulabs.taxisplus.domain.Usuario;
import com.menulabs.taxisplus.domain.dto.UserCreateForm;
import com.menulabs.taxisplus.repositories.UsuarioRepository;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UsuarioRepository userRepository;


	public Optional<Usuario> getUserById(long id) {
		LOGGER.debug("Getting user={}", id);
		return Optional.ofNullable(userRepository.findOne(id));
	}

	public Optional<Usuario> getUserByEmail(String email) {
		LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

	public Collection<Usuario> getAllUsers() {
		LOGGER.debug("Getting all users");
		return userRepository.findAll(new Sort("email"));
	}

	public Usuario create(UserCreateForm form) {
		Usuario Usuario = new Usuario();
		Usuario.setEmail(form.getEmail());
		Usuario.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		Usuario.setRole(form.getRole());
		return userRepository.save(Usuario);
	}
	
	public Usuario update(UserCreateForm form) {
		Usuario Usuario = userRepository.findOne(form.getId());
		Usuario.setEmail(form.getEmail());
		Usuario.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		Usuario.setRole(form.getRole());
		return userRepository.save(Usuario);
	}
	
	public void delete (Long id){
		userRepository.delete(id);
	}

}
