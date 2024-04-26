package com.sena.seguridad.Service.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.seguridad.Entity.Role;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Seguridad.IRoleRepository;
import com.sena.seguridad.IService.Seguridad.IRoleService;
import com.sena.seguridad.Service.ABaseService;

@Service
public class RoleService extends ABaseService<Role> implements IRoleService{

	@Override
	protected IBaseRepository<Role, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IRoleRepository repository;

	
}
