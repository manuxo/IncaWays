package pe.edu.upc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "compravuelo")
public class Compravuelo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	int nronino;
	@NotNull
	int nroadulto;
	@NotNull
	int nrofc;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date fechaviaje;
	@NotNull
	double montototal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Vuelo vuelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNronino() {
		return nronino;
	}

	public void setNronino(int nronino) {
		this.nronino = nronino;
	}

	public int getNroadulto() {
		return nroadulto;
	}

	public void setNroadulto(int nroadulto) {
		this.nroadulto = nroadulto;
	}

	public int getNrofc() {
		return nrofc;
	}

	public void setNrofc(int nrofc) {
		this.nrofc = nrofc;
	}

	public Date getFechaviaje() {
		return fechaviaje;
	}

	public void setFechaviaje(Date fechaviaje) {
		this.fechaviaje = fechaviaje;
	}

	public double getMontototal() {
		return montototal;
	}

	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
