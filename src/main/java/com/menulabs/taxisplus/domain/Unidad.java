package com.menulabs.taxisplus.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "UNIDADES")
public class Unidad {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID", nullable = false, updatable = false)
	    private Long id;
	
	    @Column(name = "NUM_PLACAS")
		private String numPlacas;

	    @Basic(optional = false)
	    @Column(name = "NUMERO_ECONOMICO")
	    private Integer numeroEconomico;
		@Basic(optional = false)
	    @Column(name = "MARCA")
	    private String marca;
	    @Basic(optional = false)
	    @Column(name = "MODELO")
	    private String modelo;
	    @Basic(optional = false)
	    @Column(name = "AC")
	    private String ac;
	    @Basic(optional = false)
	    @Column(name = "RADIO_TELECOM")
	    private String radioTelecom;
	    @Basic(optional = false)
	    @Column(name = "RADIO_AM_FM")
	    private String radioAmFm;
	    @Basic(optional = false)
	    @Column(name = "AUX")
	    private String aux;
	    @Basic(optional = false)
	    @Column(name = "BT")
	    private String bt;
	    @Column(name = "ID_ASEGURADORA")
	    private long idAseguradora;

		@ManyToOne
		@JoinColumn(name = "ID_ASEGURADORA", referencedColumnName="ID")
		@MapsId("id")
		private Aseguradora aseguradora;

	    public Unidad() {
	    }
	    
	    public Unidad(Integer numeroEconomico, String marca, String modelo, String ac,
				String radioTelecom, String radioAmFm, String aux, String bt, long idAseguradora
				, String numPlacas) {
			super();
			this.numeroEconomico = numeroEconomico;
			this.marca = marca;
			this.modelo = modelo;
			this.ac = ac;
			this.radioTelecom = radioTelecom;
			this.radioAmFm = radioAmFm;
			this.aux = aux;
			this.bt = bt;
			this.idAseguradora = idAseguradora;
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

		public Aseguradora getAseguradora() {
			return aseguradora;
		}

		public void setAseguradora(Aseguradora aseguradora) {
			this.aseguradora = aseguradora;
		}

		public long getIdAseguradora() {
			return idAseguradora;
		}

		public void setIdAseguradora(long idAseguradora) {
			this.idAseguradora = idAseguradora;
		}

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
	    
}
