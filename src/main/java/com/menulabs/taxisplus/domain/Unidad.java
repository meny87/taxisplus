package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "unidades")
public class Unidad {

	 @Size(max = 10)
	    @Column(name = "NUM_PLACA")
	    private String numPlaca;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "NUMERO_ECONOMICO")
	    private Integer numeroEconomico;
		@Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 10)
	    @Column(name = "MARCA")
	    private String marca;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 20)
	    @Column(name = "MODELO")
	    private String modelo;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "AC")
	    private String ac;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "RADIO_TELECOM")
	    private String radioTelecom;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "RADIO_AM_FM")
	    private String radioAmFm;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "AUX")
	    private String aux;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "BT")
	    private String bt;
	    @Column(name = "ID_ASEGURADORA")
	    private int idAseguradora;
	  
	    @ManyToOne
		@JoinColumn(name = "ID", referencedColumnName="ID_ASEGURADORA")
		@MapsId("resName")
		private Aseguradora aseguradora;

	    public Unidad() {
	    }
	    
	    public Unidad(String numPlaca, Integer numeroEconomico, String marca, String modelo, String ac,
				String radioTelecom, String radioAmFm, String aux, String bt, Aseguradora aseguradora) {
			super();
			this.numPlaca = numPlaca;
			this.numeroEconomico = numeroEconomico;
			this.marca = marca;
			this.modelo = modelo;
			this.ac = ac;
			this.radioTelecom = radioTelecom;
			this.radioAmFm = radioAmFm;
			this.aux = aux;
			this.bt = bt;
			this.aseguradora = aseguradora;
		}

		public String getNumPlaca() {
			return numPlaca;
		}

		public void setNumPlaca(String numPlaca) {
			this.numPlaca = numPlaca;
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

		public Aseguradora getAseguradora() {
			return aseguradora;
		}

		public void setAseguradora(Aseguradora aseguradora) {
			this.aseguradora = aseguradora;
		}

		public int getIdAseguradora() {
			return idAseguradora;
		}

		public void setIdAseguradora(int idAseguradora) {
			this.idAseguradora = idAseguradora;
		}

	    
}
