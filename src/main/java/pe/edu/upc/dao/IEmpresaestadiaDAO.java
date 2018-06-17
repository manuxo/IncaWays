package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Empresaestadia;
@Repository
public interface IEmpresaestadiaDAO extends JpaRepository<Empresaestadia, Long> {
	List<Empresaestadia> findAll();
	@Query("select em from Empresaestadia em inner join em.user us where us.id = :idUser")
	Empresaestadia findByUser(@Param("idUser") Long idUser);
}
