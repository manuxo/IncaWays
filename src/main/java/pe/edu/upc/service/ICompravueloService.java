package pe.edu.upc.service;


import java.util.List;

import pe.edu.upc.entity.Compravuelo;

public interface ICompravueloService {
	public void saveCompraVuelo(Compravuelo cv);
	
	public List<Compravuelo> findAll();
	public Compravuelo findById(Long id);
	public List<Compravuelo> findByIdEmpresa(Long idEmpresa);
	public List<Compravuelo> findByIdUsuario(Long idUsuario);
}
