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
		double costoAdulto = cv.getVuelo().getTarifaadulto() * cv.getVuelo().getTarifabase();
		double costoNino = cv.getVuelo().getTarifanino()* cv.getVuelo().getTarifabase();
		double costoFC = cv.getVuelo().getTarifafc()* cv.getVuelo().getTarifabase();
		double montototal = costoAdulto * cv.getNroadulto() + costoNino * cv.getNronino() + costoFC * cv.getNrofc();
		cv.setMontototal(montototal);
		cv.setFechaviaje(cv.getVuelo().getFechasalida());
		cvs.save(cv);
	}

}
