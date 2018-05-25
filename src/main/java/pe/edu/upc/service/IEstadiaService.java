package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Estadia;

public interface IEstadiaService {
	public void saveEstadia(Estadia estadia);
	public void deleteEstadia(Long id);
	public Estadia findById(Long id);
	public List<Estadia> findAll();
	//public Estadia findByEmpresa(Empresaestadia ee); O
	//public Estadia findByEmpresaID(int id);
}
