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
@Table(name = "usuario")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellido;
	@NotNull
	private int nrotarjeta;
	@NotNull
	private int codigocompra;
	@NotNull
	private int cvv;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Users user;
	
	
    @OneToMany(mappedBy="usuario",
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL
				)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Compravuelo> comprasvuelo;
	
    @OneToMany(
    		mappedBy="usuario",
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL
				)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Compraestadia> comprasestadia;
    
    public Usuario() {
		
    	comprasestadia=new ArrayList<>();
    	comprasvuelo=new ArrayList<>();
    	
	}
    
    public List<Compravuelo> getComprasvuelo() {
		return comprasvuelo;
	}

	public void setComprasvuelo(List<Compravuelo> comprasvuelo) {
		this.comprasvuelo = comprasvuelo;
	}

	public List<Compraestadia> getComprasestadia() {
		return comprasestadia;
	}

	public void setComprasestadia(List<Compraestadia> comprasestadia) {
		this.comprasestadia = comprasestadia;
	}

	public void addCompravuelo(Compravuelo compravuelo) {
    	comprasvuelo.add(compravuelo);
    }
    
    public void addCompraestadia(Compraestadia compraestadia) {
    	comprasestadia.add(compraestadia);
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNrotarjeta() {
		return nrotarjeta;
	}
	public void setNrotarjeta(int nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}
	public int getCodigocompra() {
		return codigocompra;
	}
	public void setCodigocompra(int codigocompra) {
		this.codigocompra = codigocompra;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
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
	
	
}
