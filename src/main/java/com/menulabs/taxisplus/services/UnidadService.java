package com.menulabs.taxisplus.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Operador;
import com.menulabs.taxisplus.domain.Unidad;
import com.menulabs.taxisplus.domain.dto.UnidadCreateForm;
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
	
	public Unidad create(UnidadCreateForm form) {
		Unidad u = new Unidad(
				form.getNumeroEconomico(),
				form.getMarca(),
				form.getModelo(),
				form.getAc(),
				form.getRadioTelecom(),
				form.getRadioAmFm(),
				form.getAux(),
				form.getBt(),
				form.getIdAseguradora(),
				form.getNumPlacas()
				);		
		return unidadRepository.save(u);
	}
	
	public Unidad update(UnidadCreateForm form) {
		Unidad u = unidadRepository.findOne(form.getId());	
		u.setNumeroEconomico(form.getNumeroEconomico());
		u.setMarca(form.getMarca());
		u.setModelo(form.getModelo());
		u.setAc(form.getAc());
		u.setRadioTelecom(form.getRadioTelecom());
		u.setRadioAmFm(form.getRadioAmFm());
		u.setAux(form.getAux());
		u.setBt(form.getBt());
		u.setIdAseguradora(form.getIdAseguradora());
		u.setNumPlacas(form.getNumPlacas());
		return unidadRepository.save(u);
	}
	
	public void delete (Long id){
		unidadRepository.delete(id);
	}
	
	public List<Long> listUnidadIDs(){
		return unidadRepository.getUnidadIDs();
	}
		
	public Optional<Unidad> getUnidadByNumPlacas(String numPlacas) {
		LOGGER.debug("Getting unidad={}", numPlacas);
		return unidadRepository.findOneByNumPlacas(numPlacas);
	}

}
