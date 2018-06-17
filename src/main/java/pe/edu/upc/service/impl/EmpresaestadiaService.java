package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.IEmpresaestadiaDAO;
import pe.edu.upc.entity.Empresaestadia;
import pe.edu.upc.service.IEmpresaEstadiaService;
@Service
public class EmpresaestadiaService implements IEmpresaEstadiaService {
	@Autowired
	private IEmpresaestadiaDAO ees;

	@Override
	@Transactional
	public void saveEmpresaestadia(Empresaestadia ee) {
		// TODO Auto-generated method stub
		ees.save(ee);
	}

	@Override
	@Transactional
	public void deleteEmpresaestadia(Long id) {
		// TODO Auto-generated method stub
		ees.deleteById(id);
	}

	@Override
	public List<Empresaestadia> findAll() {
		// TODO Auto-generated method stub
		return ees.findAll();
	}

	@Override
	public Empresaestadia findByUser(Long idUser) {
		// TODO Auto-generated method stub
		return ees.findByUser(idUser);
	}

}
