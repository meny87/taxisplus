package com.menulabs.taxisplus.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import com.menulabs.taxisplus.domain.Socio;
import com.menulabs.taxisplus.domain.Unidad;
import com.menulabs.taxisplus.domain.dto.SocioCreateForm;
import com.menulabs.taxisplus.services.SocioService;
import com.menulabs.taxisplus.services.UnidadService;

@Controller
public class SocioController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SocioController.class);
    @Autowired
    private UnidadService unidadService;
	
    private final SocioService socioService;
    private final SocioCreateFormValidator socioCreateFormValidator;

    @Autowired
    public SocioController(SocioService socioService, SocioCreateFormValidator socioCreateFormValidator) {
        this.socioService = socioService;
        this.socioCreateFormValidator = socioCreateFormValidator;
    }
    
    @ModelAttribute("unidades")
    public List<Unidad> populateUnidades() {
    	return unidadService.getAllUnidades();
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
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/socio/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id){
    	Optional<Socio>  s = socioService.getSocioById(id);
    	SocioCreateForm form = new SocioCreateForm();

		form.setTelmovil(s.get().getTelmovil());
		form.setNombre(s.get().getNombre());
		form.setApellidopaterno(s.get().getApellidopaterno());
		form.setApellidomaterno(	s.get().getApellidomaterno() );
		form.setDireccion(	s.get().getDireccion());
		form.setTelparticular(s.get().getTelparticular());
		
    	form.setId(s.get().getId());
    	form.setIdUnidad(s.get().getIdUnidad());

	
        return new ModelAndView("socios/socio_edit", "form", form);
    }
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/socio/{id}/edit", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") SocioCreateForm form, BindingResult bindingResult){
    	 LOGGER.debug("Processing socio create form={}, bindingResult={}", form, bindingResult);
         if (bindingResult.hasErrors()) {
             // failed validation
             return "socios/socio_edit";
         }
         try {
        	 socioService.update(form);
         } catch (DataIntegrityViolationException e) {
             // probably email already exists - very rare case when multiple admins are adding same user
             // at the same time and form validation has passed for more than one of them.
             //LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
             //bindingResult.reject("telmovil.exists", "telmovil already exists");
             return "socios/socio_edit";
         }
         // ok, redirect
         return "redirect:/socios/";
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
        return "redirect:/socios/";
    }  
    
	
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/socio/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
    	socioService.delete(id);
        return new ModelAndView("redirect:/socios/");
    }

}
