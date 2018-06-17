package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Users;

@Repository
public interface IUserDAO extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}
