package com.menulabs.taxisplus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.menulabs.taxisplus.services.UnidadService;

@Controller
public class UnidadesController {
	
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UnidadesController.class);
	    
	    @Autowired
	    private  UnidadService unidadService;

	    @RequestMapping("/unidades")
	    public ModelAndView getUnidadesPage() {
	        LOGGER.debug("Getting unidades page");
	        return new ModelAndView("unidades/unidades", "unidades", unidadService.getAllUnidades());
	    }

}
