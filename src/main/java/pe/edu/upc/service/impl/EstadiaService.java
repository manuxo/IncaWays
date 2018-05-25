package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.IEstadiaDAO;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.service.IEstadiaService;
@Service
public class EstadiaService implements IEstadiaService {

	@Autowired
	private IEstadiaDAO es;
	
	@Override
	@Transactional
	public void saveEstadia(Estadia estadia) {
		// TODO Auto-generated method stub
		es.save(estadia);
	}

	@Override
	@Transactional
	public void deleteEstadia(Long id) {
		// TODO Auto-generated method stub
		es.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Estadia findById(Long id) {
		// TODO Auto-generated method stub
		return es.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Estadia> findAll() {
		// TODO Auto-generated method stub
		return es.findAll();
	}

}
