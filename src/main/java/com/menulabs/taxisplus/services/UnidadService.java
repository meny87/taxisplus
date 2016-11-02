package com.menulabs.taxisplus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.repositories.UnidadRepository;

@Service
public class UnidadService {

	
	@Autowired
	private UnidadRepository unidadRepository;
}
