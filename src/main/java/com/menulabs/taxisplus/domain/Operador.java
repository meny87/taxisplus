package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "operadores")
public class Operador {
	
    @Basic(optional = false)
    @Column(name = "Placas_ID")
    private String placasID;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido_paterno")
    private String apellidopaterno;
    @Basic(optional = false)
    @Column(name = "Apellido_materno")
    private String apellidomaterno;
    @Basic(optional = false)
    @Column(name = "Calle_numero")
    private String callenumero;
    @Basic(optional = false)
    @Column(name = "Colonia")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "CP")
    private int cp;
    @Basic(optional = false)
    @Column(name = "Tel_particular")
    private String telparticular;
    @Basic(optional = false)
    @Column(name = "Tel_movil")
    private String telmovil;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    public Operador() {
    }

    public Operador(String telmovil) {
        this.telmovil = telmovil;
    }

    public Operador(String telmovil, String placasID, String nombre, String apellidopaterno, String apellidomaterno, String callenumero, String colonia, int cp, String telparticular) {
        this.telmovil = telmovil;
        this.placasID = placasID;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.callenumero = callenumero;
        this.colonia = colonia;
        this.cp = cp;
        this.telparticular = telparticular;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getPlacasID() {
        return placasID;
    }

    public void setPlacasID(String placasID) {
        this.placasID = placasID;
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

    public String getCallenumero() {
        return callenumero;
    }

    public void setCallenumero(String callenumero) {
        this.callenumero = callenumero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telmovil != null ? telmovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.telmovil == null && other.telmovil != null) || (this.telmovil != null && !this.telmovil.equals(other.telmovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.menulabs.taxisplus.domain.Operador[ telmovil=" + telmovil + " ]";
    }

}
