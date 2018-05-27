package pe.edu.upc.service;



import java.util.List;

import pe.edu.upc.entity.Compraestadia;

public interface ICompraestadiaService {

	public void saveCompraestadia(Compraestadia ce);
	
	public List<Compraestadia> findAll();
	
	//public List<Compraestadia> findByIDEstadia(int id);
	//public List<Compraestadia> findByIDUsuario(int id);
	
}
