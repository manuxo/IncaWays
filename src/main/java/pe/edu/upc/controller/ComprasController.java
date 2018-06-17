package pe.edu.upc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.ICompraestadiaService;
import pe.edu.upc.service.ICompravueloService;
import pe.edu.upc.service.IEstadiaService;
import pe.edu.upc.service.IVueloService;

import java.util.List;


@Controller
public class ComprasController {
	
	@Autowired
	private ICompravueloService serviciocv;
	
	@Autowired
	private ICompraestadiaService servicioce;
	
	
	@Autowired
	private IVueloService servicioVuelo;
	
	@Autowired
	private IEstadiaService servicioEstadia;
	
	 
	 
	//aqui van las funciones que dependen de las vistas.
	
	@GetMapping(value = "/compras/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Mis Compras");
		List<Compravuelo> compravuelos = serviciocv.findAll();
		List<Compraestadia> compraestadias = servicioce.findAll();
		model.addAttribute("compravuelos", compravuelos);
		model.addAttribute("compraestadias", compraestadias);
		return "compras/listar";
	}
	
	
	
	@RequestMapping(value = "/vuelo/ver/{id}", method= RequestMethod.POST)
	// public String guardar(Compravuelo compravuelo) {
	public String guardar(Model model, Compravuelo compravuelo, @PathVariable(value = "id") Long id) {		
		
		Vuelo vuelo = servicioVuelo.findById(id);
		compravuelo.setVuelo(vuelo);
		
		System.out.print("\n\n\n\n\n\n");
		System.out.println("Usuario: " + compravuelo.getUsuario().getNombre());
		System.out.println("Vuelo: " + compravuelo.getVuelo().getOrigen());
		
		try {
			serviciocv.saveCompraVuelo(compravuelo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/compras/listar";
	}
	
	@RequestMapping(value = "/estadia/ver/{id}", method= RequestMethod.POST)
	// public String guardar(Compravuelo compravuelo) {
	public String guardar(Model model, Compraestadia compraestadia, @PathVariable(value = "id") Long id) {
		
		Estadia estadia = servicioEstadia.findById(id);
		compraestadia.setEstadia(estadia);
		
		
		servicioce.saveCompraestadia(compraestadia);
		
		
		
		return "redirect:/estadia/listar";
	}
	
}
