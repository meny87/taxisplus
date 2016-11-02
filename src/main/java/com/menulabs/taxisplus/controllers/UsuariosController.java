package com.menulabs.taxisplus.controllers;

import com.menulabs.taxisplus.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuariosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosController.class);
    
    @Autowired
    private  UserService userService;

    @RequestMapping("/usuarios")
    public ModelAndView getUsersPage() {
        LOGGER.debug("Getting users page");
        return new ModelAndView("usuarios", "usuarios", userService.getAllUsers());
    }


}
