package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Compraestadia;
import pe.edu.upc.entity.Compravuelo;
@Repository
public interface ICompravueloDAO extends JpaRepository<Compravuelo, Long> {
	List<Compravuelo> findAll();
	/*
	@Query("select c from Compravuelo c join fetch c.usuario where c.id=?1")
	List<Compravuelo> findByUser(int id);
	
	
	@Query("select c from Compravuelo c join fetch c.vuelo cc join fetch cc.empresavuelo ccc where ccc.id=?1")
	List<Compravuelo> findByEmpresa(int id);
	*/
}
