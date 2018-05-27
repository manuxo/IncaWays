package pe.edu.upc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.upc.entity.Empresaestadia;
import pe.edu.upc.entity.Empresavuelo;
import pe.edu.upc.service.IEmpresaEstadiaService;
import pe.edu.upc.service.IEmpresaVueloService;

@Controller
public class EmpresasController {
	
	@Autowired
	private IEmpresaVueloService servicioVuelo;
	
	@Autowired
	private IEmpresaEstadiaService servicioEstadia;
	
	
	
	
	
	//TODO: EMPRESA VUELO
	@GetMapping(value="/empresavuelo/registrar")
	public String registrarEV(Model model){
		model.addAttribute("titulo","Registrar Aerolinea");
		model.addAttribute("empresavuelo", new Empresavuelo());
		return "empresavuelo/registrar";
	}
	@RequestMapping(value = "/empresavuelo/registrar", method= RequestMethod.POST)
	public String guardarEmpresaVuelo(@Valid Empresavuelo empresavuelo, BindingResult bindingResult) {
		servicioVuelo.saveEmpresavuelo(empresavuelo);
		return "redirect:/";
	}
	
	//TODO: EMPRESA ESTADIA
	@GetMapping(value="/empresaestadia/registrar")
	public String registrarES(Model model){
		model.addAttribute("titulo","Registrar Empresa de Estadias");
		model.addAttribute("empresaestadia", new Empresaestadia());
		return "empresaestadia/registrar";
	}
	@RequestMapping(value = "/empresaestadia/registrar", method= RequestMethod.POST)
	public String guardarEmpresaEstadia(@Valid Empresaestadia empresaestadia, BindingResult bindingResult) {
		servicioEstadia.saveEmpresaestadia(empresaestadia);
		return "redirect:/";
	}
}
