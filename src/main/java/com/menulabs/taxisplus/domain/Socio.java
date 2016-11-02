package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "socios")
public class Socio {

	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Placas_ID")
    private String placasID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Apellido_paterno")
    private String apellidopaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Apellido_materno")
    private String apellidomaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Tel_particular")
    private String telparticular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Tel_movil")
    private String telmovil;

    public Socio() {
    }

    public Socio(String placasID) {
        this.placasID = placasID;
    }

    public Socio(String placasID, String nombre, String apellidopaterno, String apellidomaterno, String direccion, String telparticular, String telmovil) {
        this.placasID = placasID;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.direccion = direccion;
        this.telparticular = telparticular;
        this.telmovil = telmovil;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placasID != null ? placasID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.placasID == null && other.placasID != null) || (this.placasID != null && !this.placasID.equals(other.placasID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.menulabs.taxisplus.domain.Socios[ placasID=" + placasID + " ]";
    }
}
