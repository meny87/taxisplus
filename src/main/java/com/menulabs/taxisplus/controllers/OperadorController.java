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

import com.menulabs.taxisplus.components.OperadorCreateFormValidator;
import com.menulabs.taxisplus.domain.Operador;
import com.menulabs.taxisplus.domain.dto.OperadorCreateForm;
import com.menulabs.taxisplus.services.OperadorService;


@Controller
public class OperadorController {
	
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(OperadorController.class);
	    private final OperadorService operadorService;
	    private final OperadorCreateFormValidator operadorCreateFormValidator;

	    @Autowired
	    public OperadorController(OperadorService operadorService, OperadorCreateFormValidator operadorCreateFormValidator) {
	        this.operadorService = operadorService;
	        this.operadorCreateFormValidator = operadorCreateFormValidator;
	    }

	    @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	        binder.addValidators(operadorCreateFormValidator);
	    }
	    
	    @RequestMapping("/operador/{id}")
	    public ModelAndView getOperadorPage(@PathVariable Long id) {
	        LOGGER.debug("Getting operador page for user={}", id);
	        return new ModelAndView("operador", "operador", operadorService.getOperadorById(id)
	                .orElseThrow(() -> new NoSuchElementException(String.format("Operador=%s not found", id))));
	    }
	    
	    @RequestMapping(value = "/operador/create", method = RequestMethod.GET)
	    public ModelAndView getOperadorCreatePage() {
	        LOGGER.debug("Getting user create form");
	        return new ModelAndView("operador_create", "form", new OperadorCreateForm());
	    }

	    @RequestMapping(value = "/operador/create", method = RequestMethod.POST)
	    public String handleUserCreateForm(@Valid @ModelAttribute("form") OperadorCreateForm form, BindingResult bindingResult) {
	        LOGGER.debug("Processing operador create form={}, bindingResult={}", form, bindingResult);
	        if (bindingResult.hasErrors()) {
	            // failed validation
	            return "operador_create";
	        }
	        try {
	        	operadorService.create(form);
	        } catch (DataIntegrityViolationException e) {
	            // probably email already exists - very rare case when multiple admins are adding same user
	            // at the same time and form validation has passed for more than one of them.
	            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
	            bindingResult.reject("telmovil.exists", "Telmovil already exists");
	            return "operador_create";
	        }
	        // ok, redirect
	        return "redirect:/operadores";
	    }  
	    
	    
	    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
	    @RequestMapping(value = "/operador/{id}/edit", method = RequestMethod.GET)
	    public ModelAndView edit(@PathVariable Long id){
	    	Optional<Operador>  op = operadorService.getOperadorById(id);
	    	OperadorCreateForm form = new OperadorCreateForm();

	    	
			form.setTelmovil(op.get().getTelmovil());
			form.setPlacasID(op.get().getPlacasID());
			form.setNombre(op.get().getNombre());
			form.setApellidopaterno(op.get().getApellidopaterno());
			form.setApellidomaterno(	op.get().getApellidomaterno() );
				form.setCallenumero(	op.get().getCallenumero());
				form.setColonia(	op.get().getColonia());
				form.setCp(op.get().getCp());
				form.setTelparticular(op.get().getTelparticular());
	        return new ModelAndView("operador_edit", "form", form);
	    }
	    
	    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
	    @RequestMapping(value = "/operador/{id}/edit", method = RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("form") OperadorCreateForm form, BindingResult bindingResult){
	    	 LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
	         if (bindingResult.hasErrors()) {
	             // failed validation
	             return "operador_edit";
	         }
	         try {
	        	 operadorService.update(form);
	         } catch (DataIntegrityViolationException e) {
	             // probably email already exists - very rare case when multiple admins are adding same user
	             // at the same time and form validation has passed for more than one of them.
	             LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
	             bindingResult.reject("telmovil.exists", "telmovil already exists");
	             return "operador_edit";
	         }
	         // ok, redirect
	         return "redirect:/operadores";
	    }
	    
	    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
	    @RequestMapping(value = "/operador/{id}/delete", method = RequestMethod.GET)
	    public ModelAndView delete(@PathVariable long id) {
	    	operadorService.delete(id);
	        return new ModelAndView("redirect:/operadores");
	    }

}
