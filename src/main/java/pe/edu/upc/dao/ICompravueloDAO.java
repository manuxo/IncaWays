package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entity.Compravuelo;

@Repository
public interface ICompravueloDAO extends JpaRepository<Compravuelo, Long> {
	List<Compravuelo> findAll();
	
	@Query("select c from Compravuelo c join fetch c.vuelo v join fetch v.empresavuelo em where em.id=:idEmpresa")
	List<Compravuelo> findByIdEmpresa(@Param("idEmpresa") Long idEmpresa);
	
	@Query("select c from Compravuelo c join fetch c.usuario us where us.id=:idUsuario")
	List<Compravuelo> findByIdUsuario(@Param("idUsuario")Long idUsuario);
}
