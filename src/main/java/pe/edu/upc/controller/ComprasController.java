package pe.edu.upc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Users;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.ICompraestadiaService;
import pe.edu.upc.service.ICompravueloService;
import pe.edu.upc.service.IEstadiaService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IVueloService;
import pe.edu.upc.service.impl.JpaUserDetailsService;

import java.security.Principal;
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
	
	@Autowired
	private IUsuarioService servicioUsuarios;
	
	@Autowired
	private JpaUserDetailsService servicioUsers;
	 
	//aqui van las funciones que dependen de las vistas.
	
	@Secured("ROLE_Cliente")
	@GetMapping(value = "/compras/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Mis Compras");
		List<Compravuelo> compravuelos = serviciocv.findAll();
		List<Compraestadia> compraestadias = servicioce.findAll();
		model.addAttribute("compravuelos", compravuelos);
		model.addAttribute("compraestadias", compraestadias);
		return "compras/listar";
	}
	
	
	@Secured("ROLE_Cliente")
	@PostMapping(value = "/vuelo/ver/{id}")
	// public String guardar(Compravuelo compravuelo) {
	public String guardar(Model model, Compravuelo compravuelo, @PathVariable(value = "id") Long id) {		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		
		Usuario usuario = servicioUsuarios.findByUser(user.getId());
		compravuelo.setUsuario(usuario);
		Vuelo vuelo = servicioVuelo.findById(id);
		compravuelo.setVuelo(vuelo);
		
		serviciocv.saveCompraVuelo(compravuelo);
		
		return "redirect:/compras/listar";
	}
	
	@Secured("ROLE_Cliente")
	@PostMapping(value = "/estadia/ver/{id}")
	public String guardar(Model model, Compraestadia compraestadia, @PathVariable(value = "id") Long id) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		
		Usuario usuario = servicioUsuarios.findByUser(user.getId());
		compraestadia.setUsuario(usuario);
		Estadia estadia = servicioEstadia.findById(id);
		compraestadia.setEstadia(estadia);
		
		
		servicioce.saveCompraestadia(compraestadia);
		
		
		
		return "redirect:/estadia/listar";
	}
	
}
