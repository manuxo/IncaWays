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
	List<Vuelo> findByOrigenAndDestinoAndFechasalida(@Param("origen") String origen,
	                             @Param("destino") String destino,
	                             @Param("fechasalida") Date fechasalida);
	@Query("select v from Vuelo v where v.id =:id")
	Vuelo findByIdVuelo(@Param("id") Long id);
	
	
	@Query("select v from Vuelo v join fetch v.empresavuelo em where em.id =:idEmpresa")
	List<Vuelo> findByEmpresaId(@Param("idEmpresa") Long idEmpresa);
	
}
