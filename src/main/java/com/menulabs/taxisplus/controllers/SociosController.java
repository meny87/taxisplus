package com.menulabs.taxisplus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.menulabs.taxisplus.services.SocioService;

@Controller
public class SociosController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(SociosController.class);

	
	@Autowired
    private  SocioService socioService;

    @RequestMapping("/socios")
    public ModelAndView getSociosPage() {
        LOGGER.debug("Getting socios page");
        return new ModelAndView("socios/socios", "socios", socioService.getAllSocios());
    }

}
