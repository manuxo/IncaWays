package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Empresaestadia;
@Repository
public interface IEmpresaestadiaDAO extends JpaRepository<Empresaestadia, Long> {
	List<Empresaestadia> findAll();
}
