package pe.edu.upc.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Vuelo;
@Repository
public interface IVueloDAO extends JpaRepository<Vuelo,Long> {
	
	@Query("select v from Vuelo v where v.origen = :origen and v.destino = :destino and v.fechasalida=:fechasalida")
	Vuelo findByOrigenAndDestinoAndFechasalida(@Param("origen") String lastname,
	                             @Param("destino") String firstname,
	                             @Param("fechasalida") Date fechasalida);
}
