package pe.edu.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.IUsuarioDAO;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDAO us;
	
	
	@Override
	@Transactional
	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		us.save(usuario);
	}

	@Override
	@Transactional
	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		us.deleteById(id);
	}

}
