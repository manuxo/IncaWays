package pe.edu.upc.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Compraestadia;
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
		
		List<Usuario> usuarios = servicioUsuario.findAll();
		
		Compraestadia compraestadia = new Compraestadia();
		
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("compraestadia",compraestadia);
		model.addAttribute("vuelo", vuelo);
		return "vuelo/ver";
	}
	
}
