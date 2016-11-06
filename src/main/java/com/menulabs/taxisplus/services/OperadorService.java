package com.menulabs.taxisplus.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Operador;
import com.menulabs.taxisplus.domain.dto.UserCreateForm;
import com.menulabs.taxisplus.repositories.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository operadorRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


	public Operador getUserByTelmovil(String id) {
		LOGGER.debug("Getting operator={}", id);
		return operadorRepository.findOne(id);
	}

	public List<Operador> getAllOperators() {
		LOGGER.debug("Getting all operators");
		return operadorRepository.findAll(new Sort("apellidopaterno"));
	}

	public Operador create(UserCreateForm form) {
		Operador Operador = new Operador();

		return operadorRepository.save(Operador);
	}


}
