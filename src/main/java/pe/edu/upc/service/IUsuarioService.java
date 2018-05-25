package pe.edu.upc.service;

import pe.edu.upc.entity.Usuario;

public interface IUsuarioService {

	public void saveUsuario(Usuario usuario);
	public void deleteUsuario(Long id);
	
	
}
