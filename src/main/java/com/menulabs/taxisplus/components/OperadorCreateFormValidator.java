package com.menulabs.taxisplus.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.menulabs.taxisplus.domain.dto.OperadorCreateForm;
import com.menulabs.taxisplus.services.OperadorService;

@Component
public class OperadorCreateFormValidator implements Validator {

		    @Autowired
		    private OperadorService operadorService;

		    private static final Logger LOGGER = LoggerFactory.getLogger(OperadorCreateFormValidator.class);

		    @Override
		    public boolean supports(Class<?> clazz) {
		        return clazz.equals(OperadorCreateForm.class);
		    }

		    @Override
		    public void validate(Object target, Errors errors) {
		        LOGGER.debug("Validating {}", target);
		        OperadorCreateForm form = (OperadorCreateForm) target;
		        if (form.getId() == 0){
		        	validateTelmovil(errors, form);
			    }	
		    }

		    
		    private void validateTelmovil(Errors errors, OperadorCreateForm form) {
		        if (operadorService.getOperadorByTelmovil(form.getTelmovil()).isPresent()) {
		            errors.reject("telmovil.exists", "Operador with this telmovil already exists");
		        }
		}
	
}
