package pe.edu.upc.controller;


import java.sql.Time;
import java.util.List;

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

import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.entity.Empresavuelo;
import pe.edu.upc.entity.Users;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.IEmpresaVueloService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IVueloService;
import pe.edu.upc.service.impl.JpaUserDetailsService;
import pe.edu.upc.util.ComboBuilder;
import pe.edu.upc.viewmodel.VueloViewModel;

@Controller
public class VueloController {
	
	@Autowired
	private IVueloService servicio;
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	@Autowired
	private IEmpresaVueloService servicioEmpresaVuelo;
	
	@Autowired
	private JpaUserDetailsService servicioUsers;
	
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
	
	@Secured("ROLE_EmpresaV")
	@GetMapping(value="/vuelo/misvuelos")
	public String listarPorEmpresaVuelo(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		
		Empresavuelo empresavuelo = servicioEmpresaVuelo.findByUser(user.getId());
		
		
		model.addAttribute("titulo", "Listado de vuelos");
		List<Vuelo> vuelos = servicio.findByIdEmpresa(empresavuelo.getId());
		
		// model.addAttribute("clientes", clienteService.findAll());
		// TODO
		model.addAttribute("vuelos", vuelos);
		
		//Objeto utilizado para la busqueda de vuelos dentro de la vista
		model.addAttribute("vuelo",new Vuelo());
		
		return "vuelo/misvuelos";
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
		
		model.addAttribute("compravuelo",compravuelo);
		
		return "vuelo/ver";
	}
	
	@Secured("ROLE_EmpresaV")
	@GetMapping(value = "/vuelo/crear")
	public String crear(Model model) {
		
		model.addAttribute("ciudades",ComboBuilder.ciudadesDisponibles());
		model.addAttribute("aviones",ComboBuilder.avionesDisponibles());
		
		model.addAttribute("contenedor",new VueloViewModel());
		model.addAttribute("titulo","Publicar Vuelo");
		return "vuelo/crear";
	}
	
	@Secured("ROLE_EmpresaV")
	@PostMapping(value = "/vuelo/crear")
	public String guardar(@Valid VueloViewModel contenedor, BindingResult bindingResult) {
		contenedor.getVuelo().setFechasalida(contenedor.formatStringToSqlDate(contenedor.getFechasalida()));
		contenedor.getVuelo().setHorasalida(Time.valueOf(contenedor.getHorasalida()));
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresavuelo empresavuelo = servicioEmpresaVuelo.findByUser(user.getId());
		
		contenedor.getVuelo().setEmpresavuelo(empresavuelo);
		
		servicio.saveVuelo(contenedor.getVuelo());
		return "redirect:/vuelo/misvuelos";
	}
	
	@Secured("ROLE_EmpresaV")
	@GetMapping(value= "/vuelo/editar/{id}")
	public String editar(Model model, @PathVariable(value="id") Long id) {
		
		VueloViewModel contenedor = new VueloViewModel();
		Vuelo vuelo = servicio.findById(id);
		contenedor.setVuelo(vuelo);
		contenedor.setFechasalida(vuelo.getFechasalida().toString());
		contenedor.setHorasalida(vuelo.getHorasalida().toString());
		model.addAttribute("contenedor",contenedor);
		model.addAttribute("ciudades",ComboBuilder.ciudadesDisponibles());
		model.addAttribute("aviones",ComboBuilder.avionesDisponibles());
		model.addAttribute("idVuelo",contenedor.getVuelo().getId());
		model.addAttribute("titulo","Editar Vuelo #" + vuelo.getId());
		
		
		return "vuelo/editar";
	}
	
	@Secured("ROLE_EmpresaV")
	@PostMapping(value= "/vuelo/editar")
	public String update(Model model, @Valid VueloViewModel contenedor, @RequestParam(value="idVuelo") Long idVuelo) {
		contenedor.getVuelo().setFechasalida(contenedor.formatStringToSqlDate(contenedor.getFechasalida()));
		contenedor.getVuelo().setHorasalida(Time.valueOf(contenedor.getHorasalida()));
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresavuelo empresavuelo = servicioEmpresaVuelo.findByUser(user.getId());
		contenedor.getVuelo().setEmpresavuelo(empresavuelo);
		
		contenedor.getVuelo().setId(idVuelo);
		servicio.saveVuelo(contenedor.getVuelo());
		
		return "redirect:/vuelo/misvuelos";
	}
	
	@Secured("ROLE_EmpresaV")
	@GetMapping(value="/vuelo/eliminar/{id}")
	public String delete(@PathVariable(value="id")Long id) {
		servicio.deleteVuelo(id);
		return "redirect:/vuelo/misvuelos";
	}
	
}

