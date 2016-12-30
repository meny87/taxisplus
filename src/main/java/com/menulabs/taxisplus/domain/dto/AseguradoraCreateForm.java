package com.menulabs.taxisplus.domain.dto;


public class AseguradoraCreateForm {
	
    private long id = 0;
 	private String nombre = "";
 	private String direccion  = "";
 	private String telefono  = "";
 	private String nombreResposable  = "";
 	private String numeroEmergencia1  = "";
 	private String numeroEmergencia2  = "";
 	private String comentarios  = "";
 	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombreResposable() {
		return nombreResposable;
	}
	public void setNombreResposable(String nombreResposable) {
		this.nombreResposable = nombreResposable;
	}
	public String getNumeroEmergencia1() {
		return numeroEmergencia1;
	}
	public void setNumeroEmergencia1(String numeroEmergencia1) {
		this.numeroEmergencia1 = numeroEmergencia1;
	}
	public String getNumeroEmergencia2() {
		return numeroEmergencia2;
	}
	public void setNumeroEmergencia2(String numeroEmergencia2) {
		this.numeroEmergencia2 = numeroEmergencia2;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
