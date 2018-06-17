package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Empresaestadia;

public interface IEmpresaEstadiaService {

	public void saveEmpresaestadia(Empresaestadia ee);
	public void deleteEmpresaestadia(Long id);
	public List<Empresaestadia> findAll();
	public Empresaestadia findByUser(Long idUser);
	
}
