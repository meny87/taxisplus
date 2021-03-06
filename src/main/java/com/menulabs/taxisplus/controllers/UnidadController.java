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

import com.menulabs.taxisplus.components.UnidadCreateFormValidator;
import com.menulabs.taxisplus.domain.Aseguradora;
import com.menulabs.taxisplus.domain.Unidad;
import com.menulabs.taxisplus.domain.dto.UnidadCreateForm;
import com.menulabs.taxisplus.services.AseguradoraService;
import com.menulabs.taxisplus.services.UnidadService;

@Controller
public class UnidadController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UnidadController.class);
	
    private final UnidadService unidadService;
    private final UnidadCreateFormValidator unidadCreateFormValidator;

    @Autowired
    public UnidadController(UnidadService unidadService, UnidadCreateFormValidator unidadCreateFormValidator) {
        this.unidadService = unidadService;
        this.unidadCreateFormValidator = unidadCreateFormValidator;
    }
    
    
	@Autowired
	private  AseguradoraService aseguradoraService;
    
    @ModelAttribute("aseguradoras")
    public List<Aseguradora> populateAseguradoras() {
    	return aseguradoraService.getAllAseguradoras();
    }
    
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(unidadCreateFormValidator);
    }
    
    @RequestMapping("/unidad/{id}")
    public ModelAndView getUnidadPage(@PathVariable Long id) {
        LOGGER.debug("Getting unidad page for user={}", id);
        return new ModelAndView("unidades/unidad", "unidad", unidadService.getUnidadById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Unidad=%s not found", id))));
    }
    
    @RequestMapping(value = "/unidad/create", method = RequestMethod.GET)
    public ModelAndView getUnidadCreatePage() {
        LOGGER.debug("Getting unidad create form");
        return new ModelAndView("unidades/unidad_create", "form", new UnidadCreateForm());
    }
    
    @RequestMapping(value = "/unidad/create", method = RequestMethod.POST)
    public String handleUnidadCreateForm(@Valid @ModelAttribute("form") UnidadCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing unidad create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "unidad_create";
        }
        try {
        	unidadService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            //LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
            //bindingResult.reject("telmovil.exists", "Telmovil already exists");
            return "unidades/unidad_create";
        }
        // ok, redirect
        return "redirect:/unidades/";
    }  
	
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/unidad/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id){
    	Optional<Unidad>  u = unidadService.getUnidadById(id);
    	UnidadCreateForm form = new UnidadCreateForm();

    	form.setAc(u.get().getAc());
    	form.setAux(u.get().getAux());
    	form.setBt(u.get().getBt());
    	form.setMarca(u.get().getMarca());
    	form.setModelo(u.get().getModelo());
    	form.setNumeroEconomico(u.get().getNumeroEconomico());
    	form.setNumPlacas(u.get().getNumPlacas());
    	form.setRadioAmFm(u.get().getRadioAmFm());
    	form.setRadioTelecom(u.get().getRadioTelecom());
    	form.setId(u.get().getId());
    	form.setIdAseguradora(u.get().getIdAseguradora());
    	//form.setIdOperador(u.get().getIdOperador());
    	
	
        return new ModelAndView("unidades/unidad_edit", "form", form);
    }
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/unidad/{id}/edit", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") UnidadCreateForm form, BindingResult bindingResult){
    	 LOGGER.debug("Processing unidad create form={}, bindingResult={}", form, bindingResult);
         if (bindingResult.hasErrors()) {
             // failed validation
             return "unidades/unidad_edit";
         }
         try {
        	 unidadService.update(form);
         } catch (DataIntegrityViolationException e) {
             // probably email already exists - very rare case when multiple admins are adding same user
             // at the same time and form validation has passed for more than one of them.
             //LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate telmovil", e);
             //bindingResult.reject("telmovil.exists", "telmovil already exists");
             return "unidades/unidad_edit";
         }
         // ok, redirect
         return "redirect:/unidades/";
    }
    
	
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/unidad/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
    	unidadService.delete(id);
        return new ModelAndView("redirect:/unidades/");
    }

}
