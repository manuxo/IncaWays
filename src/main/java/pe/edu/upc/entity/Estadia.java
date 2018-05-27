package pe.edu.upc.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "estadia")
public class Estadia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	String direccion;
	@NotNull
	String ciudad;
	@NotNull
	String pais;
	double costoxdia;
	@NotNull
	String tipoestadia;
	@NotNull
	boolean comprado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresaestadia empresaestadia;

	@OneToMany(mappedBy="estadia",fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Compraestadia> comprasestadia;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getCostoxdia() {
		return costoxdia;
	}

	public void setCostoxdia(double costoxdia) {
		this.costoxdia = costoxdia;
	}

	public String getTipoestadia() {
		return tipoestadia;
	}

	public void setTipoestadia(String tipoestadia) {
		this.tipoestadia = tipoestadia;
	}

	public Empresaestadia getEmpresaestadia() {
		return empresaestadia;
	}

	public void setEmpresaestadia(Empresaestadia empresaestadia) {
		this.empresaestadia = empresaestadia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	
}
