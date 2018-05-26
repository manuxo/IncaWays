package pe.edu.upc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.IEstadiaService;

@Controller
public class EstadiaController {
	
	@Autowired
	private IEstadiaService servicio;
	//aqui van las funciones que dependen de las vistas.
	
	@GetMapping(value = "/estadia/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de estadias");
		
		List<Estadia> estadias = servicio.findAll();
		
		// model.addAttribute("clientes", clienteService.findAll());
		// TODO
		model.addAttribute("estadias", estadias);
		
		//Objeto utilizado para la busqueda de vuelos dentro de la vista
		model.addAttribute("estadia",new Estadia());
		
		return "estadia/listar";
	}
	
	
	@GetMapping(value = "/estadia/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Estadia estadia = servicio.findById(id);
		if (estadia == null) {
			flash.addFlashAttribute("error", "La estadia no existe en la base de datos");
			return "redirect:estadia/listar";
		}

		model.addAttribute("estadia", estadia);
		return "estadia/ver";
	}
}
