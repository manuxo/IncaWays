package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.IEmpresavueloDAO;
import pe.edu.upc.entity.Empresavuelo;
import pe.edu.upc.service.IEmpresaVueloService;
@Service
public class EmpresavueloService implements IEmpresaVueloService {
	@Autowired
	private IEmpresavueloDAO evs;
	
	@Override
	@Transactional
	public void saveEmpresavuelo(Empresavuelo ev) {
		// TODO Auto-generated method stub
		evs.save(ev);
	}

	@Override
	@Transactional
	public void deleteEmpresavuelo(Long id) {
		// TODO Auto-generated method stub
		evs.deleteById(id);
	}

	@Override
	public List<Empresavuelo> findAll() {
		// TODO Auto-generated method stub
		return evs.findAll();
	}

	@Override
	public Empresavuelo findByUser(Long idUser) {
		// TODO Auto-generated method stub
		return evs.findByUser(idUser);
	}

}
