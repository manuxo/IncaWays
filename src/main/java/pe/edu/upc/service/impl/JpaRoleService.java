package pe.edu.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IRoleDAO;
import pe.edu.upc.entity.Role;

@Service
public class JpaRoleService {
	@Autowired
	private IRoleDAO roleRepository;
	
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
}
