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
		
		//REGLA DE NEGOCIO
		//Una vez realidad la compra, estadia.comprado = true
		ce.getEstadia().setComprado(true);
		ces.save(ce);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Compraestadia> findAll() {
		// TODO Auto-generated method stub
		return ces.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Compraestadia> findByIdEmpresa(Long idEmpresa) {
		// TODO Auto-generated method stub
		return ces.findByIdEmpresa(idEmpresa);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Compraestadia> findByIdUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		return ces.findByIdUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Compraestadia findById(Long id) {
		// TODO Auto-generated method stub
		return ces.findById(id).orElse(null);
	}


}
