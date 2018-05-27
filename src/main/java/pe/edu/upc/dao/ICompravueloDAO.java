package pe.edu.upc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Compravuelo;
@Repository
public interface ICompravueloDAO extends JpaRepository<Compravuelo, Long> {
	List<Compravuelo> findAll();
}
