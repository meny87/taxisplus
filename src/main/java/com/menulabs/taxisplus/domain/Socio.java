package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SOCIOS")
public class Socio {

	@Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = true)
    @Column(name = "AP_PATERNO")
    private String apellidopaterno;
    @Basic(optional = true)
    @Column(name = "AP_MATERNO")
    private String apellidomaterno;
    @Basic(optional = true)
    @Column(name = "DIRECCION")
 	private String direccion;
    @Basic(optional = true)
    @Column(name = "TEL_PARTICULAR")
    private String telparticular;
    @Basic(optional = true)
    @Column(name = "TEL_MOVIL")
    private String telmovil;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    
    @Column(name = "ID_UNIDAD")
    private int idUnidad;
    
    
    
    public Socio() {
    }



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



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}
	
}
