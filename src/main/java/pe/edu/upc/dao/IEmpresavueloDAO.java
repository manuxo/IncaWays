package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Empresavuelo;
@Repository
public interface IEmpresavueloDAO extends JpaRepository<Empresavuelo,Long> {
	List<Empresavuelo> findAll();
	
	@Query("select ev from Empresavuelo ev inner join ev.user us where us.id = :idUser")
	Empresavuelo findByUser(@Param("idUser") Long idUser);
}
