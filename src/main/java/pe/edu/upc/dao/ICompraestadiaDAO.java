package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Compraestadia;
@Repository
public interface ICompraestadiaDAO extends JpaRepository<Compraestadia, Long> {
	List<Compraestadia> findAll();
	
	@Query("select c from Compraestadia c join fetch c.estadia e join fetch e.empresaestadia em where em.id =:idEmpresa")
	List<Compraestadia> findByIdEmpresa(@Param("idEmpresa")Long idEmpresa);
	
	@Query("select c from Compraestadia c join fetch c.usuario us where us.id=:idUsuario")
	List<Compraestadia> findByIdUsuario(@Param("idUsuario")Long idUsuario);
}
