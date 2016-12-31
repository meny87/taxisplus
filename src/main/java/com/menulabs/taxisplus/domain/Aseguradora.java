package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASEGURADORAS")
public class Aseguradora {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID", nullable = false, updatable = false)
	    private Long id;
		@Basic(optional = false)
	    @Column(name = "NOMBRE")
	 	private String nombre;
	    @Basic(optional = true)
	    @Column(name = "DIRECCION")
	 	private String direccion;
	    @Basic(optional = false)
	    @Column(name = "TELEFONO")
	 	private String telefono;
	    @Basic(optional = true)
	    @Column(name = "NOMBRE_RESPONSABLE")
	 	private String nombreResponsable;
	    @Basic(optional = false)
	    @Column(name = "NUMERO_EMERGENCIA1")
	 	private String numeroEmergencia1;
	    @Basic(optional = true)
	    @Column(name = "NUMERO_EMERGENCIA2")
	 	private String numeroEmergencia2;
	    @Basic(optional = true)
	    @Column(name = "COMENTARIOS")
	 	private String comentarios;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
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
		public String getNombreResponsable() {
			return nombreResponsable;
		}
		public void setNombreResponsable(String nombreResposable) {
			this.nombreResponsable = nombreResposable;
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
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
	 	public Aseguradora(){
	 		
	 	}
	 	
	    public Aseguradora(String nombre, String direccion, String telefono, String nombreResposable,
				String numeroEmergencia1, String numeroEmergencia2, String comentarios) {
			super();
			this.nombre = nombre;
			this.direccion = direccion;
			this.telefono = telefono;
			this.nombreResponsable = nombreResposable;
			this.numeroEmergencia1 = numeroEmergencia1;
			this.numeroEmergencia2 = numeroEmergencia2;
			this.comentarios = comentarios;
		}

}
