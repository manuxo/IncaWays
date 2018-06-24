package pe.edu.upc.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.IVueloDAO;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.IVueloService;
@Service
public class VueloService implements IVueloService {

	@Autowired
	private IVueloDAO vs;
	
	@Override
	@Transactional
	public void saveVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		
		//REGLA DE NEGOCIO
		//Al publicar un servicio se inicializa el campo boolean comprado = false
		vuelo.setComprado(false);
		vs.save(vuelo);
	}

	@Override
	@Transactional
	public void deleteVuelo(Long id) {
		// TODO Auto-generated method stub
		vs.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Vuelo findById(Long id) {
		
		return vs.findById(id).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vuelo> findAll() {
		// TODO Auto-generated method stub
		return vs.findAll();
	}

	@Override
	public List<Vuelo> findByOrigenAndDestinoAndFechasalida(String origen, String destino, Date fechasalida) {
		// TODO Auto-generated method stub
		return vs.findByOrigenAndDestinoAndFechasalida(origen, destino, fechasalida);
	}

	@Override
	public Vuelo findByIdVuelo(Long id) {
		// TODO Auto-generated method stub
		return vs.findByIdVuelo(id);
	}

	@Override
	public List<Vuelo> findByIdEmpresa(Long idEmpresa) {
		// TODO Auto-generated method stub
		return vs.findByEmpresaId(idEmpresa);
	}

}
