package com.menulabs.taxisplus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.menulabs.taxisplus.services.OperadorService;

@Controller

public class OperadoresController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(OperadoresController.class);
	    
	    @Autowired
	    private  OperadorService operadorService;

	    @RequestMapping("/operadores")
	    public ModelAndView getOperadoresPage() {
	        LOGGER.debug("Getting operadores page");
	        return new ModelAndView("operadores/operadores", "operadores", operadorService.getAllOperators());
	    }

}
