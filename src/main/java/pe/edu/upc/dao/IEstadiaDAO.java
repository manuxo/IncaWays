package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Estadia;
@Repository
public interface IEstadiaDAO extends JpaRepository<Estadia, Long> {

}
