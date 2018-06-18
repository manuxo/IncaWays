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

import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.entity.Empresaestadia;
import pe.edu.upc.entity.Empresavuelo;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Users;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.ICompraestadiaService;
import pe.edu.upc.service.ICompravueloService;
import pe.edu.upc.service.IEmpresaEstadiaService;
import pe.edu.upc.service.IEmpresaVueloService;
import pe.edu.upc.service.IEstadiaService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IVueloService;
import pe.edu.upc.service.impl.JpaUserDetailsService;

import java.util.List;


@Controller
public class ComprasController {
	
	@Autowired
	private ICompravueloService serviciocv;
	
	@Autowired
	private ICompraestadiaService servicioce;
	
	@Autowired
	private IEmpresaEstadiaService servicioEmpresaEstadia;
	
	@Autowired
	private IEmpresaVueloService servicioEmpresaVuelo;
	
	@Autowired
	private IVueloService servicioVuelo;
	
	@Autowired
	private IEstadiaService servicioEstadia;
	
	@Autowired
	private IUsuarioService servicioUsuarios;
	
	@Autowired
	private JpaUserDetailsService servicioUsers;
	 
	
	@Secured("ROLE_Cliente")
	@GetMapping(value = "/compras/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Mis Compras");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		
		Usuario usuario = servicioUsuarios.findByUser(user.getId());
		
		List<Compravuelo> compravuelos = serviciocv.findByIdUsuario(usuario.getId());
		List<Compraestadia> compraestadias = servicioce.findByIdUsuario(usuario.getId());
		model.addAttribute("compravuelos", compravuelos);
		model.addAttribute("compraestadias", compraestadias);
		return "compras/listar";
	}
	
	@Secured("ROLE_EmpresaE")
	@GetMapping(value= "/ventas/estadias")
	public String listarVentasEstadias(Model model) {
		model.addAttribute("titulo", "Mis Ventas");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresaestadia empresaestadia = servicioEmpresaEstadia.findByUser(user.getId());
		
		
		List<Compraestadia> compraestadias = servicioce.findByIdEmpresa(empresaestadia.getId());
		model.addAttribute("compraestadias", compraestadias);
		
		return "ventas/estadias";
	}
	
	@Secured("ROLE_EmpresaV")
	@GetMapping(value= "/ventas/vuelos")
	public String listarVentasVuelos(Model model) {
		model.addAttribute("titulo", "Mis Ventas");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Users user = servicioUsers.findByUsername(username);
		Empresavuelo empresavuelo = servicioEmpresaVuelo.findByUser(user.getId());
		
		List<Compravuelo> compravuelos = serviciocv.findByIdEmpresa(empresavuelo.getId());
		
		model.addAttribute("compravuelos",compravuelos);
		return "ventas/vuelos";
	}
	
	@Secured("ROLE_Cliente")
	@GetMapping(value="/compras/compravuelo/{id}")
	public String verCompraVuelo(Model model, @PathVariable(value="id") Long id){
		model.addAttribute("titulo","Mis Compras");
		
		Compravuelo compravuelo = serviciocv.findById(id);
		model.addAttribute("compravuelo",compravuelo);
		return "compras/compravuelo";
	}
	
	@Secured("ROLE_Cliente")
	@GetMapping(value="/compras/compraestadia/{id}")
	public String verCompraEstadia(Model model, @PathVariable(value="id") Long id){
		model.addAttribute("titulo","Mis Compras");
		
		Compraestadia compraestadia = servicioce.findById(id);
		model.addAttribute("compraestadia",compraestadia);
		return "compras/compraestadia";
	}
	
	
	@Secured("ROLE_Cliente")
	@PostMapping(value = "/vuelo/ver/{id}")
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
