package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Compraestadia;
@Repository
public interface ICompraestadiaDAO extends JpaRepository<Compraestadia, Long> {
	List<Compraestadia> findAll();
	/*
	@Query("select c from Compraestadia c join fetch c.usuario where c.id=?1")
	List<Compraestadia> findByUser(int id);
	
	@Query("select c from Compraestadia c join fetch c.estadia cc join fetch cc.empresaestadia ccc where ccc.id=?1")
	List<Compraestadia> findByEmpresa(int id);
	*/
	
}
