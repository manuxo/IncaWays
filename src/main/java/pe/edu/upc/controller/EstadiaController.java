package pe.edu.upc.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.entity.Empresaestadia;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.IEmpresaEstadiaService;
import pe.edu.upc.service.IEstadiaService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.util.ComboBuilder;

@Controller
public class EstadiaController {
	
	@Autowired
	private IEstadiaService servicio;
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	@Autowired
	private IEmpresaEstadiaService servicioEmpresaEstadia;
	
	
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

		Estadia estadiaV = servicio.findById(id);
		if (estadiaV == null) {
			flash.addFlashAttribute("error", "La estadia no existe en la base de datos");
			return "redirect:estadia/listar";
		}
		
		//Llenar combobox con los usuarios
		List<Usuario> usuarios = servicioUsuario.findAll();
		model.addAttribute("usuarios",usuarios);
		
		Compraestadia compraestadia = new Compraestadia();
		
		
		model.addAttribute("compraestadia",compraestadia);
		model.addAttribute("estadiaV", estadiaV);
		return "estadia/ver";
	}
	
	@GetMapping(value= "/estadia/crear")
	public String crear(Model model) {
		
		System.out.print("\n\n\n\n ENTREEEE \n\n\n\n");
		
		model.addAttribute("empresaestadias",servicioEmpresaEstadia.findAll());
		model.addAttribute("estadia", new Estadia());
		model.addAttribute("ciudades",ComboBuilder.ciudadesDisponibles());
		model.addAttribute("paises",ComboBuilder.paisesDisponibles());
		model.addAttribute("tipoestadias",ComboBuilder.tiposEstadia());
		model.addAttribute("titulo", "Publicar estadia");
		return "estadia/crear";
	}
	
	@RequestMapping(value = "/estadia/crear", method= RequestMethod.POST)
	public String guardar(@Valid Estadia estadia, BindingResult bindingResult) {
		servicio.saveEstadia(estadia);
		return "redirect:/estadia/listar";
	}
}
