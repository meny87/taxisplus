package com.menulabs.taxisplus.domain.dto;

import org.springframework.security.core.authority.AuthorityUtils;

import com.menulabs.taxisplus.domain.Role;
import com.menulabs.taxisplus.domain.Usuario;

public class CurrentUser extends org.springframework.security.core.userdetails.User {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

    public CurrentUser(Usuario usuario) {
        super(usuario.getEmail(), usuario.getPasswordHash(), AuthorityUtils.createAuthorityList(usuario.getRole().toString()));
        this.usuario = usuario;
    }

    public Usuario getUser() {
        return usuario;
    }

    public Long getId() {
        return usuario.getId();
    }

    public Role getRole() {
        return usuario.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "usuario=" + usuario +
                "} " + super.toString();
    }
}