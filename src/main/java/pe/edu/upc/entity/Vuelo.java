package pe.edu.upc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vuelo")
public class Vuelo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	public Long getId() {
		return id;
	}

	public Time getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(Time horasalida) {
		this.horasalida = horasalida;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public double getTarifabase() {
		return tarifabase;
	}

	public void setTarifabase(double tarifabase) {
		this.tarifabase = tarifabase;
	}

	public double getTarifanino() {
		return tarifanino;
	}

	public void setTarifanino(double tarifanino) {
		this.tarifanino = tarifanino;
	}

	public double getTarifaadulto() {
		return tarifaadulto;
	}

	public void setTarifaadulto(double tarifaadulto) {
		this.tarifaadulto = tarifaadulto;
	}

	public double getTarifafc() {
		return tarifafc;
	}

	public void setTarifafc(double tarifafc) {
		this.tarifafc = tarifafc;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}



	public Empresavuelo getEmpresavuelo() {
		return empresavuelo;
	}

	public void setEmpresavuelo(Empresavuelo empresavuelo) {
		this.empresavuelo = empresavuelo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	String avion;
	@NotNull
	double tarifabase;
	@NotNull
	double tarifanino;
	@NotNull
	double tarifaadulto;
	@NotNull
	double tarifafc;
	@NotNull
	String origen;
	@NotNull
	String destino;
	@NotNull
	boolean comprado;
	
	@NotNull
    @DateTimeFormat(pattern = "hh:mm:ss")
	Time horasalida;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date fechasalida;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresavuelo empresavuelo;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST,mappedBy="vuelo")
	@Fetch(value = FetchMode.SUBSELECT)
	List<Compravuelo> comprasvuelo;
	
}
