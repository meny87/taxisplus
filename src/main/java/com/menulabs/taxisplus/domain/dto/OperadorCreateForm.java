package com.menulabs.taxisplus.domain.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OperadorCreateForm {
	
	    @NotNull
	    @Size(min = 1, max = 50)
	    private String nombre= "";
	    @NotNull
	    @Size(min = 1, max = 20)
	    private String apellidopaterno= "";
	    @NotNull
	    @Size(min = 1, max = 20)
	    private String apellidomaterno= "";
	    @NotNull
	    @Size(min = 1, max = 100)
	    private String callenumero= "";
	    @NotNull
	    @Size(min = 1, max = 50)
	    private String colonia= "";
	    @NotNull
	    private int cp = 0;
	    @NotNull
	    @Size(min = 1, max = 20)
	    private String telparticular= "";
	    @NotNull
	    @Size(min = 1, max = 20)
	    private String telmovil= "";
	    
	    private long id  = 0;
	    
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
		    public String toString() {
		        return "com.menulabs.taxisplus.domain.dto.OperadorCreateForm[ telmovil=" + telmovil + " ]";
		    }
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}

	    

}
