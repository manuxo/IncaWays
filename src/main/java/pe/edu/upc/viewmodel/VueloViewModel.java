package pe.edu.upc.viewmodel;

import pe.edu.upc.entity.Vuelo;

public class VueloViewModel{
	private Vuelo vuelo;
	private String fechasalida;
	private String horasalida;
	
	public VueloViewModel() {
		this.vuelo = new Vuelo();
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public String getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(String fechasalida) {
		this.fechasalida = fechasalida;
	}
	public String getHorasalida() {
		return horasalida;
	}
	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}
	
	public java.sql.Date formatStringToSqlDate(String strDate) {
		java.sql.Date fecha = null;
		String anios = strDate.substring(0,4);
		
		String meses = strDate.substring(5,7);
		
		String dias = strDate.substring(8);
		
		@SuppressWarnings("deprecation")
		java.util.Date fechaFormateada = new java.util.Date(Integer.parseInt(anios), Integer.parseInt(meses), Integer.parseInt(dias));
		
		
		@SuppressWarnings("deprecation")
		java.util.Date base = new java.util.Date(1969,12,30);
		
		fecha = new java.sql.Date(fechaFormateada.getTime() - base.getTime());
		return fecha;
	}
}