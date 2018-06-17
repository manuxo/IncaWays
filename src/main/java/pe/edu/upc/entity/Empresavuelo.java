package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "empresavuelo")
public class Empresavuelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	String nombre;
	
	@NotNull
	int ruc;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Users user;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="empresavuelo")
	@Fetch(value = FetchMode.SUBSELECT)
	List<Vuelo> vuelos;
	
	public Empresavuelo() {
		// TODO Auto-generated constructor stub
		vuelos=new ArrayList<>();
	}
	
	public void addVuelo(Vuelo vuelo) {
		vuelos.add(vuelo);
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getRuc() {
		return ruc;
	}


	public void setRuc(int ruc) {
		this.ruc = ruc;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
}
