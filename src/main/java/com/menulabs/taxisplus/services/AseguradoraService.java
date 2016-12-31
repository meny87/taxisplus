package com.menulabs.taxisplus.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Aseguradora;
import com.menulabs.taxisplus.domain.dto.AseguradoraCreateForm;
import com.menulabs.taxisplus.repositories.AseguradoraRepository;

@Service
public class AseguradoraService {
	
	@Autowired
	private AseguradoraRepository aseguradoraRepository;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AseguradoraService.class);
	
	
	public Optional<Aseguradora> getAseguradoraById(long id) {
		LOGGER.debug("Getting aseguradora={}", id);
		return Optional.ofNullable(aseguradoraRepository.findOne(id));
	}

	public List<Aseguradora> getAllAseguradoras() {
		LOGGER.debug("Getting all aseguradoras");
		return aseguradoraRepository.findAll();
	}
	
	public Aseguradora update(AseguradoraCreateForm form) {
		Aseguradora a = aseguradoraRepository.findOne(form.getId());
		
		a.setNombre(form.getNombre());
		a.setDireccion(form.getDireccion());
		a.setTelefono(form.getTelefono());
		a.setNombreResponsable(form.getNombreResponsable());
		a.setNumeroEmergencia1(form.getNumeroEmergencia1());
		a.setNumeroEmergencia2(form.getNumeroEmergencia2());
		a.setComentarios(form.getComentarios());
		
		return aseguradoraRepository.save(a);
	}
	
	
	public Aseguradora create(AseguradoraCreateForm form) {
		Aseguradora a = new Aseguradora(
				form.getNombre(),
				form.getDireccion(),
				form.getTelefono(),
				form.getNombreResponsable(),
				form.getNumeroEmergencia1(),
				form.getNumeroEmergencia2(),
				form.getComentarios());
					
		return aseguradoraRepository.save(a);
	}
	public void delete (Long id){
		aseguradoraRepository.delete(id);
	}

}
