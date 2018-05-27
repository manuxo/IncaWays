package pe.edu.upc.controller;


import java.sql.Date;
import java.sql.Time;
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
import pe.edu.upc.entity.Compravuelo;
import pe.edu.upc.entity.Empresavuelo;
import pe.edu.upc.entity.Estadia;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.Vuelo;
import pe.edu.upc.service.IEmpresaVueloService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IVueloService;

@Controller
public class VueloController {
	
	@Autowired
	private IVueloService servicio;
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	@Autowired
	private IEmpresaVueloService servicioEmpresaVuelo;
	
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
		
		model.addAttribute("compravuelo",compravuelo);
		
		return "vuelo/ver";
	}
	
	@GetMapping(value = "/vuelo/crear")
	public String crear(Model model) {
		
		List<Empresavuelo> empresavuelos = servicioEmpresaVuelo.findAll();
		model.addAttribute("empresavuelos", empresavuelos);
		
		model.addAttribute("contenedor",new ContenedorFormulario());
		model.addAttribute("titulo","Publicar Vuelo");
		return "vuelo/crear";
	}
	
	
	@RequestMapping(value = "/vuelo/crear", method= RequestMethod.POST)
	// public String guardar(Compravuelo compravuelo) {
	public String guardar(@Valid ContenedorFormulario contenedor, BindingResult bindingResult) {
		contenedor.getVuelo().setFechasalida(contenedor.formatStringToSqlDate(contenedor.getFechasalida()));
		contenedor.getVuelo().setHorasalida(Time.valueOf(contenedor.getHorasalida()));
		servicio.saveVuelo(contenedor.getVuelo());
		return "redirect:/vuelo/listar";
	}
	
	
}

class ContenedorFormulario{
	private Vuelo vuelo;
	private String fechasalida;
	private String horasalida;
	
	public ContenedorFormulario() {
		this.vuelo = new Vuelo();
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public String getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(String fechasalida) {
		this.fechasalida = fechasalida;
	}
	public String getHorasalida() {
		return horasalida;
	}
	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}
	
	public Date formatStringToSqlDate(String strDate) {
		Date fecha = null;
		String anios = strDate.substring(0,4);
		
		String meses = strDate.substring(5,7);
		
		String dias = strDate.substring(8);
		
		@SuppressWarnings("deprecation")
		java.util.Date fechaFormateada = new java.util.Date(Integer.parseInt(anios), Integer.parseInt(meses), Integer.parseInt(dias));
		
		
		@SuppressWarnings("deprecation")
		java.util.Date base = new java.util.Date(1969,12,30);
		
		fecha = new Date(fechaFormateada.getTime() - base.getTime());
		return fecha;
	}
}
