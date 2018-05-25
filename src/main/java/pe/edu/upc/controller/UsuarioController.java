package pe.edu.upc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.upc.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService servicio;
	
	//aqui van las funciones que dependen de las vistas.
	
}
