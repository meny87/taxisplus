package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "unidades")
public class Unidad {

	 @Size(max = 10)
	    @Column(name = "Placas_ID")
	    private String placasID;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "Numero_economico")
	    private Integer numeroeconomico;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 10)
	    @Column(name = "Marca")
	    private String marca;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 20)
	    @Column(name = "Modelo")
	    private String modelo;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "Num_plazas")
	    private int numplazas;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "Aire_Acondicionado")
	    private String aireAcondicionado;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "Radio_telecomunicador")
	    private String radiotelecomunicador;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "Radio_am_fm")
	    private String radioamfm;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "Conector_aux")
	    private String conectoraux;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "Bluetooth")
	    private String bluetooth;

	    public Unidad() {
	    }

	    public Unidad(Integer numeroeconomico) {
	        this.numeroeconomico = numeroeconomico;
	    }

	    public Unidad(Integer numeroeconomico, String marca, String modelo, int numplazas, String aireAcondicionado, String radiotelecomunicador, String radioamfm, String conectoraux, String bluetooth) {
	        this.numeroeconomico = numeroeconomico;
	        this.marca = marca;
	        this.modelo = modelo;
	        this.numplazas = numplazas;
	        this.aireAcondicionado = aireAcondicionado;
	        this.radiotelecomunicador = radiotelecomunicador;
	        this.radioamfm = radioamfm;
	        this.conectoraux = conectoraux;
	        this.bluetooth = bluetooth;
	    }

	    public String getPlacasID() {
	        return placasID;
	    }

	    public void setPlacasID(String placasID) {
	        this.placasID = placasID;
	    }

	    public Integer getNumeroeconomico() {
	        return numeroeconomico;
	    }

	    public void setNumeroeconomico(Integer numeroeconomico) {
	        this.numeroeconomico = numeroeconomico;
	    }

	    public String getMarca() {
	        return marca;
	    }

	    public void setMarca(String marca) {
	        this.marca = marca;
	    }

	    public String getModelo() {
	        return modelo;
	    }

	    public void setModelo(String modelo) {
	        this.modelo = modelo;
	    }

	    public int getNumplazas() {
	        return numplazas;
	    }

	    public void setNumplazas(int numplazas) {
	        this.numplazas = numplazas;
	    }

	    public String getAireAcondicionado() {
	        return aireAcondicionado;
	    }

	    public void setAireAcondicionado(String aireAcondicionado) {
	        this.aireAcondicionado = aireAcondicionado;
	    }

	    public String getRadiotelecomunicador() {
	        return radiotelecomunicador;
	    }

	    public void setRadiotelecomunicador(String radiotelecomunicador) {
	        this.radiotelecomunicador = radiotelecomunicador;
	    }

	    public String getRadioamfm() {
	        return radioamfm;
	    }

	    public void setRadioamfm(String radioamfm) {
	        this.radioamfm = radioamfm;
	    }

	    public String getConectoraux() {
	        return conectoraux;
	    }

	    public void setConectoraux(String conectoraux) {
	        this.conectoraux = conectoraux;
	    }

	    public String getBluetooth() {
	        return bluetooth;
	    }

	    public void setBluetooth(String bluetooth) {
	        this.bluetooth = bluetooth;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (numeroeconomico != null ? numeroeconomico.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Unidad)) {
	            return false;
	        }
	        Unidad other = (Unidad) object;
	        if ((this.numeroeconomico == null && other.numeroeconomico != null) || (this.numeroeconomico != null && !this.numeroeconomico.equals(other.numeroeconomico))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.tp14.entities.Unidades[ numeroeconomico=" + numeroeconomico + " ]";
	    }
	
}
