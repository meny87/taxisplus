package com.menulabs.taxisplus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.repositories.SocioRepository;

@Service
public class SocioService {
	
	@Autowired
	private SocioRepository socioRepository;

}
