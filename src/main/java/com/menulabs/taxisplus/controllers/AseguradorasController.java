package com.menulabs.taxisplus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.menulabs.taxisplus.services.AseguradoraService;

@Controller
public class AseguradorasController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AseguradorasController.class);
		
	@Autowired
	private  AseguradoraService aseguradoraService;

   @RequestMapping("/aseguradoras")
   public ModelAndView getAseguradorasPage() {
       LOGGER.debug("Getting aseguradoras page");
       return new ModelAndView("aseguradoras/aseguradoras", "aseguradoras", aseguradoraService.getAllAseguradoras());
   }

}
