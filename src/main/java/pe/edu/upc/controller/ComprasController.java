package pe.edu.upc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.service.ICompraestadiaService;
import pe.edu.upc.service.ICompravueloService;

@Controller
public class ComprasController {
	
	@Autowired
	private ICompravueloService serviciocv;
	
	@Autowired
	private ICompraestadiaService servicioce;
	
	//aqui van las funciones que dependen de las vistas.
	
	
	@RequestMapping(value = "/vuelo/comprar", method = RequestMethod.POST)
	// public String guardar(Compravuelo compravuelo) {
	public String guardar(@Valid Compravuelo compravuelo, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {
		
		return null;
	}
}
