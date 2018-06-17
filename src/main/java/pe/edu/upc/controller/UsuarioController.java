package pe.edu.upc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.upc.entity.Role;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.impl.JpaRoleService;
import pe.edu.upc.service.impl.JpaUserDetailsService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private JpaUserDetailsService userService;
	
	@Autowired
	private JpaRoleService roleService;
	
	@GetMapping(value="/usuario/registrar")
	public String registrar(Model model){
		model.addAttribute("titulo","Registrar usuario");
		model.addAttribute("usuario", new Usuario());
		
		return "usuario/registrar";
	}
	
	@RequestMapping(value = "/usuario/registrar", method= RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult bindingResult) {
		usuario.getUser().setEnabled(true);
		
		Role role = new Role();
		role.setAuthority("ROLE_Cliente");
		role.setUser(usuario.getUser());
		userService.saveUser(usuario.getUser());
		roleService.saveRole(role);
		usuarioService.saveUsuario(usuario);
		return "redirect:/login";
	}
}
