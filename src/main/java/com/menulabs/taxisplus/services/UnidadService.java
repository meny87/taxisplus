package com.menulabs.taxisplus.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Unidad;
import com.menulabs.taxisplus.repositories.UnidadRepository;

@Service
public class UnidadService {

	
	@Autowired
	private UnidadRepository unidadRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UnidadService.class);
	
	
	public Optional<Unidad> getUnidadById(long id) {
		LOGGER.debug("Getting unidad={}", id);
		return Optional.ofNullable(unidadRepository.findOne(id));
	}

	public List<Unidad> getAllUnidades() {
		LOGGER.debug("Getting all unidades");
		return unidadRepository.findAll();
	}

}
