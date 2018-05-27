package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.ICompraestadiaDAO;
import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.service.ICompraestadiaService;
@Service
public class CompraestadiaService implements ICompraestadiaService {

	@Autowired
	private ICompraestadiaDAO ces;
	
	@Override
	@Transactional
	public void saveCompraestadia(Compraestadia ce) {
		// TODO Auto-generated method stub
		double costoxdia = ce.getEstadia().getCostoxdia();
		double costodecompra = costoxdia * ce.getNrodias();
		ce.setCosto(costodecompra);
		ces.save(ce);
	}

	@Override
	public List<Compraestadia> findAll() {
		// TODO Auto-generated method stub
		return ces.findAll();
	}

}
