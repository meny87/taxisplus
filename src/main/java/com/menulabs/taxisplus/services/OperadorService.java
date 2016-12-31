package com.menulabs.taxisplus.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Operador;
import com.menulabs.taxisplus.domain.dto.OperadorCreateForm;
import com.menulabs.taxisplus.repositories.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository operadorRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OperadorService.class);


	public Optional<Operador> getOperadorByTelmovil(String tel) {
		LOGGER.debug("Getting operator={}", tel);
		return Optional.ofNullable(operadorRepository.findByTelmovil(tel));
	}
	
	public Optional<Operador> getOperadorById(long id) {
		LOGGER.debug("Getting operator={}", id);
		return Optional.ofNullable(operadorRepository.findOne(id));
	}

	public List<Operador> getAllOperators() {
		LOGGER.debug("Getting all operators");
		return operadorRepository.findAll(new Sort("apellidopaterno"));
	}
	public Operador create(OperadorCreateForm form) {
		Operador op = new Operador(form.getTelmovil(),
				//form.getPlacasID(), 
				form.getNombre(), 
				form.getApellidopaterno(), 
				form.getApellidomaterno(), form.getCallenumero(), form.getColonia(),
				form.getCp(), form.getTelparticular(),
				form.getIdUnidad()
				);		
		return operadorRepository.save(op);
	}
	
	public Operador update(OperadorCreateForm form) {
		Operador op = operadorRepository.findOne(form.getId());
		
		op.setTelmovil(form.getTelmovil());
		//op.setPlacasID(form.getPlacasID());
		op.setNombre(form.getNombre());
		op.setApellidopaterno(form.getApellidopaterno());
		op.setApellidomaterno(	form.getApellidomaterno() );
			op.setCallenumero(	form.getCallenumero());
			op.setColonia(	form.getColonia());
			op.setCp(form.getCp());
			op.setTelparticular(form.getTelparticular());
		op.setIdUnidad(form.getIdUnidad());

		return operadorRepository.save(op);
	}
	
	public void delete (Long id){
		operadorRepository.delete(id);
	}


}
