package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Estadia;
@Repository
public interface IEstadiaDAO extends JpaRepository<Estadia, Long> {
	
	@Query("select e from Estadia e join fetch e.empresaestadia em where em.id =:idEmpresa")
	public List<Estadia> findByIdEmpresa(@Param("idEmpresa") Long idEmpresa);
 }
