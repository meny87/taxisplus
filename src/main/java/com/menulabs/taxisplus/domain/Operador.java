package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "OPERADORES")
public class Operador {
	
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "AP_PATERNO")
    private String apellidopaterno;
    @Basic(optional = false)
    @Column(name = "AP_MATERNO")
    private String apellidomaterno;
    @Basic(optional = false)
    @Column(name = "CALLE_NUMERO")
    private String callenumero;
    @Basic(optional = false)
    @Column(name = "COLONIA")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "CP")
    private int cp;
    @Basic(optional = false)
    @Column(name = "TEL_PARTICULAR")
    private String telparticular;
    @Basic(optional = false)
    @Column(name = "TEL_MOVIL")
    private String telmovil;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    public Operador() {
    }

    public Operador(String telmovil) {
        this.telmovil = telmovil;
    }

    public Operador(String telmovil, String nombre, String apellidopaterno, String apellidomaterno, String callenumero, String colonia, int cp, String telparticular) {
        this.telmovil = telmovil;
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
