package com.menulabs.taxisplus.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.menulabs.taxisplus.domain.dto.OperadorCreateForm;
import com.menulabs.taxisplus.domain.dto.UnidadCreateForm;
import com.menulabs.taxisplus.services.UnidadService;

@Component
public class UnidadCreateFormValidator implements Validator {
	
	@Autowired
    private UnidadService unidadService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UnidadCreateFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UnidadCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        UnidadCreateForm form = (UnidadCreateForm) target;
        if (form.getId() == 0){
        	validateNumPlacas(errors, form);
	    }	
    }
    
    private void validateNumPlacas(Errors errors, UnidadCreateForm form) {
        if (unidadService.getUnidadByNumPlacas(form.getNumPlacas()).isPresent()) {
            errors.reject("numPlacas.exists", "Unidad with this numPlacas already exists");
        }
    }

}
