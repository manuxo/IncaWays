package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compraestadia")
public class Compraestadia implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getNrodias() {
		return nrodias;
	}

	public void setNrodias(int nrodias) {
		this.nrodias = nrodias;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	double costo;
	@NotNull
	int nrodias;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Estadia estadia;
	
	
}
