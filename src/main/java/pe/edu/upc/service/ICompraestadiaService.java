package pe.edu.upc.service;



import java.util.List;

import pe.edu.upc.entity.Compraestadia;

public interface ICompraestadiaService {

	public void saveCompraestadia(Compraestadia ce);
	
	public List<Compraestadia> findAll();
	
	public List<Compraestadia> findByIdEmpresa(Long idEmpresa);
	
	public List<Compraestadia> findByIdUsuario(Long idUsuario);
}
