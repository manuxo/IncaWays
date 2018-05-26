package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario,Long> {
	
	@Query("select u from Usuario u where u.id=?1")
	public Usuario findByIdUsuario(Long id);
	
	
}
