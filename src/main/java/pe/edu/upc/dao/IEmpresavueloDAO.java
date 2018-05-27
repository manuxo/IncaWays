package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Empresavuelo;
@Repository
public interface IEmpresavueloDAO extends JpaRepository<Empresavuelo,Long> {
	List<Empresavuelo> findAll();
}
