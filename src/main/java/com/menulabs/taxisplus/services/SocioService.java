package com.menulabs.taxisplus.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Socio;
import com.menulabs.taxisplus.domain.dto.SocioCreateForm;
import com.menulabs.taxisplus.repositories.SocioRepository;

@Service
public class SocioService {
	
	@Autowired
	private SocioRepository socioRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SocioService.class);
	
	
	public Optional<Socio> getSocioById(long id) {
		LOGGER.debug("Getting socio={}", id);
		return Optional.ofNullable(socioRepository.findOne(id));
	}

	public List<Socio> getAllSocios() {
		LOGGER.debug("Getting all socios");
		return socioRepository.findAll();
	}
	
	public Socio update(SocioCreateForm form) {
		Socio s = socioRepository.findOne(form.getId());
		
		s.setTelmovil(form.getTelmovil());
		s.setNombre(form.getNombre());
		s.setDireccion(form.getDireccion());
		s.setApellidopaterno(form.getApellidopaterno());
		s.setApellidomaterno(	form.getApellidomaterno() );
		s.setTelparticular(form.getTelparticular());
		s.setIdUnidad(form.getIdUnidad());
		
		return socioRepository.save(s);
	}
	
	
	public Socio create(SocioCreateForm form) {
		Socio s = new Socio(
				form.getNombre(), 
				form.getApellidopaterno(),
				form.getApellidomaterno(),
				form.getDireccion(),
				form.getTelparticular(),
				form.getTelmovil(),
				form.getIdUnidad()
				);		
		return socioRepository.save(s);
	}
	public void delete (Long id){
		socioRepository.delete(id);
	}

}
