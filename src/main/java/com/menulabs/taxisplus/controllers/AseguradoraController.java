package com.menulabs.taxisplus.controllers;

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

import com.menulabs.taxisplus.components.AseguradoraCreateFormValidator;
import com.menulabs.taxisplus.domain.Aseguradora;
import com.menulabs.taxisplus.domain.dto.AseguradoraCreateForm;
import com.menulabs.taxisplus.services.AseguradoraService;

@Controller
public class AseguradoraController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AseguradoraController.class);
	
	private final AseguradoraService aseguradoraService;
	private final AseguradoraCreateFormValidator aseguradoraCreateFormValidator;
	
    @Autowired
    public AseguradoraController(AseguradoraService aseguradoraService, AseguradoraCreateFormValidator aseguradoraCreateFormValidator) {
        this.aseguradoraService = aseguradoraService;
        this.aseguradoraCreateFormValidator = aseguradoraCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(aseguradoraCreateFormValidator);
    }
    
    @RequestMapping("/aseguradora/{id}")
    public ModelAndView getAseguradoraPage(@PathVariable Long id) {
        LOGGER.debug("Getting aseguradora page for user={}", id);
        return new ModelAndView("aseguradoras/aseguradora", "aseguradora", aseguradoraService.getAseguradoraById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Aseguradora=%s not found", id))));
    }
    
    @RequestMapping(value = "/aseguradora/create", method = RequestMethod.GET)
    public ModelAndView getAseguradoraCreatePage() {
        LOGGER.debug("Getting aseguradora create form");
        return new ModelAndView("aseguradoras/aseguradora_create", "form", new AseguradoraCreateForm());
    }
    
    @RequestMapping(value = "/aseguradora/create", method = RequestMethod.POST)
    public String handleAseguradoraCreateForm(@Valid @ModelAttribute("form") AseguradoraCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing aseguradora create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "aseguradora_create";
        }
        try {
        	aseguradoraService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            //LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
            //bindingResult.reject("telmovil.exists", "Telmovil already exists");
            return "aseguradoras/aseguradora_create";
        }
        // ok, redirect
        return "redirect:/aseguradoras/";
    }  
    
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/aseguradora/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id){
    	Optional<Aseguradora>  a = aseguradoraService.getAseguradoraById(id);
    	AseguradoraCreateForm form = new AseguradoraCreateForm();

    	
		//form.setPlacasID(op.get().getPlacasID());
		form.setNombre(a.get().getNombre());
		form.setDireccion(a.get().getDireccion());
		form.setTelefono(a.get().getTelefono());
		
		form.setTelefono(a.get().getTelefono());
		form.setNombreResponsable(a.get().getNombreResponsable());
		form.setNumeroEmergencia1(a.get().getNumeroEmergencia1());
		form.setNumeroEmergencia2(a.get().getNumeroEmergencia2());
		form.setComentarios(a.get().getComentarios());
    	form.setId(a.get().getId());


        return new ModelAndView("aseguradoras/aseguradora_edit", "form", form);
    }
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/aseguradora/{id}/edit", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") AseguradoraCreateForm form, BindingResult bindingResult){
    	 LOGGER.debug("Processing aseguradora create form={}, bindingResult={}", form, bindingResult);
         if (bindingResult.hasErrors()) {
             // failed validation
             return "aseguradoras/aseguradora_edit";
         }
         try {
        	 aseguradoraService.update(form);
         } catch (DataIntegrityViolationException e) {
             // probably email already exists - very rare case when multiple admins are adding same user
             // at the same time and form validation has passed for more than one of them.
             //LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
             //bindingResult.reject("telmovil.exists", "telmovil already exists");
             return "aseguradoras/aseguradora_edit";
         }
         // ok, redirect
         return "redirect:/aseguradoras/";
    }
    
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/aseguradora/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
    	aseguradoraService.delete(id);
        return new ModelAndView("redirect:/aseguradoras/");
    }

}
