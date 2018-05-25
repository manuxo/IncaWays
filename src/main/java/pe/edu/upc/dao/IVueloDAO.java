package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Vuelo;
@Repository
public interface IVueloDAO extends JpaRepository<Vuelo,Long> {

}
