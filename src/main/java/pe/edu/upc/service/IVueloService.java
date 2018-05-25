package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Vuelo;

public interface IVueloService {

	public void saveVuelo(Vuelo vuelo);
	public void deleteVuelo(Long id);
	public Vuelo findById(Long id);
	public List<Vuelo> findAll();
	//public Vuelo findByEmpresa(Empresavuelo ev); O
	//public Vuelo findByEmpresaID(int id);
}
