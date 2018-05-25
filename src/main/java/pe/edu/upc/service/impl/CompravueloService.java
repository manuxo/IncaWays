package pe.edu.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.ICompravueloDAO;
import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.service.ICompravueloService;
@Service
public class CompravueloService implements ICompravueloService {

	@Autowired
	private ICompravueloDAO cvs;
	@Override
	@Transactional
	public void saveCompraVuelo(Compravuelo cv) {
		// TODO Auto-generated method stub
		cvs.save(cv);
	}

}
