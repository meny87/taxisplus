package com.menulabs.taxisplus.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UnidadCreateForm {
	
    private long id  = 0;
	@Size(max = 10)
	private String numPlacas = "";
    @NotNull
    private Integer numeroEconomico = 0;
    @NotNull
    @Size(min = 1, max = 10)
    private String marca = "";
    @NotNull
    @Size(min = 1, max = 20)
    private String modelo = "";
    @NotNull
    @Size(min = 1, max = 1)
    private String ac = "";
    @NotNull
    @Size(min = 1, max = 1)
    private String radioTelecom = "";
    @NotNull
    @Size(min = 1, max = 1)
    private String radioAmFm = "";
    @NotNull
    @Size(min = 1, max = 1)
    private String aux = "";
    @NotNull
    @Size(min = 1, max = 1)
    private String bt = "";
    private long idAseguradora = 0;
  
 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumPlacas() {
		return numPlacas;
	}
	public void setNumPlacas(String numPlacas) {
		this.numPlacas = numPlacas;
	}
	public Integer getNumeroEconomico() {
		return numeroEconomico;
	}
	public void setNumeroEconomico(Integer numeroEconomico) {
		this.numeroEconomico = numeroEconomico;
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
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getRadioTelecom() {
		return radioTelecom;
	}
	public void setRadioTelecom(String radioTelecom) {
		this.radioTelecom = radioTelecom;
	}
	public String getRadioAmFm() {
		return radioAmFm;
	}
	public void setRadioAmFm(String radioAmFm) {
		this.radioAmFm = radioAmFm;
	}
	public String getAux() {
		return aux;
	}
	public void setAux(String aux) {
		this.aux = aux;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public long getIdAseguradora() {
		return idAseguradora;
	}
	public void setIdAseguradora(long idAseguradora) {
		this.idAseguradora = idAseguradora;
	}

}
