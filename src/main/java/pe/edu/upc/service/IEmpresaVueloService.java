package pe.edu.upc.service;


import java.util.List;

import pe.edu.upc.entity.Empresavuelo;

public interface IEmpresaVueloService {
	public void saveEmpresavuelo(Empresavuelo ev);
	public void deleteEmpresavuelo(Long id);
	public List<Empresavuelo> findAll();
	public Empresavuelo findByUser(Long idUser);
}
