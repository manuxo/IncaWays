package pe.edu.upc.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.entity.Empresaestadia;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Users;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IEmpresaEstadiaService;
import pe.edu.upc.service.IEstadiaService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.impl.JpaUserDetailsService;
import pe.edu.upc.util.ComboBuilder;

@Controller
public class EstadiaController {
	
	@Autowired
	private IEstadiaService servicio;
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	@Autowired
	private IEmpresaEstadiaService servicioEmpresaEstadia;
	
	@Autowired
	private JpaUserDetailsService servicioUsers;
	
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
	
	@Secured("ROLE_EmpresaE")
	@GetMapping(value = "estadia/misestadias")
	public String listarEstadiasPorEmpresa(Model model, HttpServletRequest request) {
		model.addAttribute("titulo", "Listado de estadias");
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresaestadia empresaestadia = servicioEmpresaEstadia.findByUser(user.getId());

		List<Estadia> estadias = servicio.findByIdEmpresa(empresaestadia.getId());
		
		model.addAttribute("estadias", estadias);
		
		model.addAttribute("estadia",new Estadia());
		
		return "estadia/misestadias";
	}
	
	@GetMapping(value = "/estadia/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Estadia estadiaV = servicio.findById(id);
		
		//Llenar combobox con los usuarios
		List<Usuario> usuarios = servicioUsuario.findAll();
		model.addAttribute("usuarios",usuarios);
		
		Compraestadia compraestadia = new Compraestadia();
		
		
		model.addAttribute("compraestadia",compraestadia);
		model.addAttribute("estadiaV", estadiaV);
		return "estadia/ver";
	}
	
	@Secured("ROLE_EmpresaE")
	@GetMapping(value= "/estadia/crear")
	public String crear(Model model) {
		model.addAttribute("estadia", new Estadia());
		model.addAttribute("ciudades",ComboBuilder.ciudadesDisponibles());
		model.addAttribute("paises",ComboBuilder.paisesDisponibles());
		model.addAttribute("tipoestadias",ComboBuilder.tiposEstadia());
		model.addAttribute("titulo", "Publicar estadia");
		return "estadia/crear";
	}
	
	@Secured("ROLE_EmpresaE")
	@PostMapping(value = "/estadia/crear")
	public String guardar(@Valid Estadia estadia, BindingResult bindingResult) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresaestadia empresaestadia = servicioEmpresaEstadia.findByUser(user.getId());
		estadia.setEmpresaestadia(empresaestadia);
		servicio.saveEstadia(estadia);
		return "redirect:/estadia/misestadias";
	}
	
	@Secured("ROLE_EmpresaE")
	@GetMapping(value="/estadia/editar/{id}")
	public String editar(Model model, @PathVariable(value="id") Long id) {
		model.addAttribute("estadia", servicio.findById(id));
		model.addAttribute("ciudades",ComboBuilder.ciudadesDisponibles());
		model.addAttribute("paises",ComboBuilder.paisesDisponibles());
		model.addAttribute("tipoestadias",ComboBuilder.tiposEstadia());
		model.addAttribute("titulo", "Publicar estadia");
		model.addAttribute("idEstadia",id);
		return "estadia/editar";
	}
	
	@Secured("ROLE_EmpresaE")
	@PostMapping(value="/estadia/editar")
	public String update(Model model, @Valid Estadia estadia, @RequestParam(value="idEstadia") Long idEstadia, RedirectAttributes flashAttributes) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresaestadia empresaestadia = servicioEmpresaEstadia.findByUser(user.getId());
		estadia.setEmpresaestadia(empresaestadia);
		estadia.setId(idEstadia);
		servicio.saveEstadia(estadia);
		
		return "redirect:/estadia/misestadias";
	}
	
	@Secured("ROLE_EmpresaE")
	@GetMapping(value="/estadia/eliminar/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		servicio.deleteEstadia(id);
		
		return "redirect:/estadia/misestadias";
	}
}
