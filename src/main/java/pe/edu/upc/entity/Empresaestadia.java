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
@Table(name = "empresaestadia")
public class Empresaestadia implements Serializable {

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
	
	@OneToMany(mappedBy="empresaestadia",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Estadia> estadias;
	
	public Empresaestadia() {
		// TODO Auto-generated constructor stub
		estadias=new ArrayList<>();
	}
	
	public void addEstadia(Estadia estadia) {
		estadias.add(estadia);
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

	public List<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(List<Estadia> estadias) {
		this.estadias = estadias;
	}
	
}
