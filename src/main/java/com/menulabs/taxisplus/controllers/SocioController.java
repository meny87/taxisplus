package com.menulabs.taxisplus.controllers;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.menulabs.taxisplus.components.SocioCreateFormValidator;
import com.menulabs.taxisplus.domain.dto.SocioCreateForm;
import com.menulabs.taxisplus.services.SocioService;

@Controller
public class SocioController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SocioController.class);

	
    private final SocioService socioService;
    private final SocioCreateFormValidator socioCreateFormValidator;

    @Autowired
    public SocioController(SocioService socioService, SocioCreateFormValidator socioCreateFormValidator) {
        this.socioService = socioService;
        this.socioCreateFormValidator = socioCreateFormValidator;
    }
    

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(socioCreateFormValidator);
    }
    
    @RequestMapping("/socio/{id}")
    public ModelAndView getUnidadPage(@PathVariable Long id) {
        LOGGER.debug("Getting socio page for user={}", id);
        return new ModelAndView("socios/socio", "socio", socioService.getSocioById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Socio=%s not found", id))));
    }
    
    @RequestMapping(value = "/socio/create", method = RequestMethod.GET)
    public ModelAndView getSocioCreatePage() {
        LOGGER.debug("Getting socio create form");
        return new ModelAndView("socios/socio_create", "form", new SocioCreateForm());
    }
    
    @RequestMapping(value = "/socio/create", method = RequestMethod.POST)
    public String handleSocioCreateForm(@Valid @ModelAttribute("form") SocioCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing socio create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "socio_create";
        }
        try {
        	socioService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            //LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
            //bindingResult.reject("telmovil.exists", "Telmovil already exists");
            return "socios/socio_create";
        }
        // ok, redirect
        return "redirect:/socios/socios";
    }  
    
	
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/socio/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
    	socioService.delete(id);
        return new ModelAndView("redirect:/socios/socios");
    }

}
