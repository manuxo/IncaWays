package pe.edu.upc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.upc.service.IEmpresaEstadiaService;
import pe.edu.upc.service.IEmpresaVueloService;

@Controller
public class EmpresasController {
	
	@Autowired
	private IEmpresaVueloService serviciovuelo;
	
	@Autowired
	private IEmpresaEstadiaService servicioestadial;
	
	//aqui van las funciones que dependen de las vistas.
}
