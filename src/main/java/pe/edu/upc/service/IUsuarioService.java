package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Usuario;

public interface IUsuarioService {

	public void saveUsuario(Usuario usuario);
	public void deleteUsuario(Long id);
	public List<Usuario> findAll();
	
}
