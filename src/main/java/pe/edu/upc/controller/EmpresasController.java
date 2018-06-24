package pe.edu.upc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.upc.entity.Empresaestadia;
import pe.edu.upc.entity.Empresavuelo;
import pe.edu.upc.entity.Role;
import pe.edu.upc.service.IEmpresaEstadiaService;
import pe.edu.upc.service.IEmpresaVueloService;
import pe.edu.upc.service.impl.JpaRoleService;
import pe.edu.upc.service.impl.JpaUserDetailsService;

@Controller
public class EmpresasController {
	
	@Autowired
	private IEmpresaVueloService servicioVuelo;
	
	@Autowired
	private IEmpresaEstadiaService servicioEstadia;
	
	@Autowired
	private JpaUserDetailsService userService;
	
	@Autowired
	private JpaRoleService roleService;
	
	
	//TODO: EMPRESA VUELO
	@GetMapping(value="/empresavuelo/registrar")
	public String registrarEV(Model model){
		model.addAttribute("titulo","Registrar Aerolinea");
		model.addAttribute("empresavuelo", new Empresavuelo());
		return "empresavuelo/registrar";
	}
	@PostMapping(value = "/empresavuelo/registrar")
	public String guardarEmpresaVuelo(@Valid Empresavuelo empresavuelo, BindingResult bindingResult) {
		empresavuelo.getUser().setEnabled(true);
		Role role = new Role();
		role.setAuthority("ROLE_EmpresaV");
		role.setUser(empresavuelo.getUser());
		userService.saveUser(empresavuelo.getUser());
		roleService.saveRole(role);
		servicioVuelo.saveEmpresavuelo(empresavuelo);
		return "redirect:/login";
	}
	
	//TODO: EMPRESA ESTADIA
	@GetMapping(value="/empresaestadia/registrar")
	public String registrarES(Model model){
		model.addAttribute("titulo","Registrar Empresa de Estadias");
		model.addAttribute("empresaestadia", new Empresaestadia());
		return "empresaestadia/registrar";
	}
	@PostMapping(value = "/empresaestadia/registrar")
	public String guardarEmpresaEstadia(@Valid Empresaestadia empresaestadia, BindingResult bindingResult) {
		
		empresaestadia.getUser().setEnabled(true);
		
		Role role = new Role();
		role.setAuthority("ROLE_EmpresaE");
		role.setUser(empresaestadia.getUser());
		userService.saveUser(empresaestadia.getUser());
		roleService.saveRole(role);
		servicioEstadia.saveEmpresaestadia(empresaestadia);
		return "redirect:/login";
	}
}
