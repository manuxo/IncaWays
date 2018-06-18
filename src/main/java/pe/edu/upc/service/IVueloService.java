package pe.edu.upc.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.entity.Vuelo;

public interface IVueloService {

	public void saveVuelo(Vuelo vuelo);
	public void deleteVuelo(Long id);
	public Vuelo findById(Long id);
	public List<Vuelo> findAll();
	
	List<Vuelo> findByOrigenAndDestinoAndFechasalida(String origen,String destino,Date fechasalida);
	//public Vuelo findByEmpresa(Empresavuelo ev); O
	//public Vuelo findByEmpresaID(int id);
	
	Vuelo findByIdVuelo(Long id);
	
	List<Vuelo> findByIdEmpresa(Long idEmpresa);
}
