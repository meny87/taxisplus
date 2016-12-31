package com.menulabs.taxisplus.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.menulabs.taxisplus.domain.dto.AseguradoraCreateForm;
import com.menulabs.taxisplus.services.AseguradoraService;

@Component
public class AseguradoraCreateFormValidator implements Validator {
	
	
	@Autowired
    private AseguradoraService aseguradoraService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AseguradoraCreateFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AseguradoraCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        AseguradoraCreateForm form = (AseguradoraCreateForm) target;
        if (form.getId() == 0){
        	//validateTelmovil(errors, form);
	    }	
    }

}
