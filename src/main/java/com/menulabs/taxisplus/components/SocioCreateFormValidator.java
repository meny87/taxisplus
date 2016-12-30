package com.menulabs.taxisplus.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.menulabs.taxisplus.domain.dto.SocioCreateForm;
import com.menulabs.taxisplus.services.SocioService;

@Component
public class SocioCreateFormValidator implements Validator {

	@Autowired
    private SocioService socioService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SocioCreateFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SocioCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        SocioCreateForm form = (SocioCreateForm) target;
        if (form.getId() == 0){
        	//validateTelmovil(errors, form);
	    }	
    }
	
}
