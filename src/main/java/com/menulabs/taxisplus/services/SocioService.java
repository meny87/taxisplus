package com.menulabs.taxisplus.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Socio;
import com.menulabs.taxisplus.repositories.SocioRepository;

@Service
public class SocioService {
	
	@Autowired
	private SocioRepository socioRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SocioService.class);
	
	
	public Optional<Socio> getSocioyId(long id) {
		LOGGER.debug("Getting socio={}", id);
		return Optional.ofNullable(socioRepository.findOne(id));
	}

	public List<Socio> getAllSocios() {
		LOGGER.debug("Getting all socios");
		return socioRepository.findAll();
	}

}
