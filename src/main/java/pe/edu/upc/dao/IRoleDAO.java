package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Role;

@Repository
public interface IRoleDAO extends JpaRepository<Role, Long>{

}
