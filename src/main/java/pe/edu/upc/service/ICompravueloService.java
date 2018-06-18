package pe.edu.upc.service;


import java.util.List;

import pe.edu.upc.entity.Compravuelo;

public interface ICompravueloService {
	public void saveCompraVuelo(Compravuelo cv);
	
	public List<Compravuelo> findAll();
	//public List<Compravuelo> findByIDVuelo(int id);
	//public List<Compravuelo> findByIDUsuario(int id);
	List<Compravuelo> findByIdEmpresa(Long idEmpresa);
	List<Compravuelo> findByIdUsuario(Long idUsuario);
}
