package pe.edu.upc.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IVueloService;


@Controller
public class VueloController {
	
	@Autowired
	private IVueloService servicio;
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	@GetMapping(value = "/vuelo/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de vuelos");
		
		List<Vuelo> vuelos = servicio.findAll();
		
		// model.addAttribute("clientes", clienteService.findAll());
		// TODO
		model.addAttribute("vuelos", vuelos);
		
		//Objeto utilizado para la busqueda de vuelos dentro de la vista
		model.addAttribute("vuelo",new Vuelo());
		
		return "vuelo/listar";
	}
	
	@GetMapping(value = "/vuelo/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Vuelo vuelo = servicio.findById(id);
		if (vuelo == null) {
			flash.addFlashAttribute("error", "El vuelo no existe en la base de datos");
			return "redirect:vuelo/listar";
		}
		model.addAttribute("vuelo", vuelo);
		
		
		List<Usuario> usuarios = servicioUsuario.findAll();
		model.addAttribute("usuarios",usuarios);
		
		
		Compravuelo compravuelo = new Compravuelo();
		compravuelo.setUsuario(new Usuario());
		compravuelo.setVuelo(new Vuelo());
		
		model.addAttribute("compravuelo",compravuelo);
		
		return "vuelo/ver";
	}
	
}
