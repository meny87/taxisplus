package com.menulabs.taxisplus.domain.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SocioCreateForm {
	
       private long id  = 0;

	   @NotNull
	   @Size(min = 1, max = 50)
	   private String nombre;
	   @NotNull
	   @Size(min = 1, max = 30)
	   private String apellidopaterno;
	   @NotNull
	   @Size(min = 1, max = 30)
	   private String apellidomaterno;
	   @NotNull 
	   @Size(min = 1, max = 100)
	   private String direccion;
	   @NotNull
	   @Size(min = 1, max = 15)
	   private String telparticular;
	   @NotNull
	   @Size(min = 1, max = 15)
	   private String telmovil;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelparticular() {
		return telparticular;
	}
	public void setTelparticular(String telparticular) {
		this.telparticular = telparticular;
	}
	public String getTelmovil() {
		return telmovil;
	}
	public void setTelmovil(String telmovil) {
		this.telmovil = telmovil;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
