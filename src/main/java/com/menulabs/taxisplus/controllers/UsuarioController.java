package com.menulabs.taxisplus.controllers;

import com.menulabs.taxisplus.components.UserCreateFormValidator;
import com.menulabs.taxisplus.domain.Usuario;
import com.menulabs.taxisplus.domain.dto.UserCreateForm;
import com.menulabs.taxisplus.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class UsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UsuarioController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping("/usuario/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return new ModelAndView("usuario", "usuario", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Usuario=%s not found", id))));
    }

    @PreAuthorize("hasAuthority('ADMINCAPTURER')")
    @RequestMapping(value = "/usuario/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @PreAuthorize("hasAuthority('ADMINCAPTURER')")
    @RequestMapping(value = "/usuario/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "user_create";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        // ok, redirect
        return "redirect:/usuarios";
    }
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/usuario/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id){
    	Optional<Usuario>  user = userService.getUserById(id);
    	UserCreateForm form = new UserCreateForm();
    	form.setEmail(user.get().getEmail());
    	form.setRole(user.get().getRole());
    	form.setId(user.get().getId());
        return new ModelAndView("user_edit", "form", form);
    }
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/usuario/{id}/edit", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult){
    	 LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
         if (bindingResult.hasErrors()) {
             // failed validation
             return "user_edit";
         }
         try {
             userService.update(form);
         } catch (DataIntegrityViolationException e) {
             // probably email already exists - very rare case when multiple admins are adding same user
             // at the same time and form validation has passed for more than one of them.
             LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
             bindingResult.reject("email.exists", "Email already exists");
             return "user_edit";
         }
         // ok, redirect
         return "redirect:/usuarios";
    }
    
    @PreAuthorize("@currentUserService.canAccessUser(principal, #id)")
    @RequestMapping(value = "/usuario/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
    	userService.delete(id);
        return new ModelAndView("redirect:/usuarios");
    }


}
