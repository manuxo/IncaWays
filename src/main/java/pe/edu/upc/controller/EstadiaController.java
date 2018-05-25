package pe.edu.upc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.upc.service.IEstadiaService;

@Controller
public class EstadiaController {
	
	@Autowired
	private IEstadiaService servicio;
	//aqui van las funciones que dependen de las vistas.
}
