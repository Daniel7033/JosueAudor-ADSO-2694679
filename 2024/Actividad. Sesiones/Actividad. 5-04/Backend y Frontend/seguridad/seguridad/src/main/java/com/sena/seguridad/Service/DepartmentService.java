package com.sena.seguridad.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.seguridad.Entity.Department;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IDepartmentRepository;
import com.sena.seguridad.IService.IDepartmentService;

@Service
public class DepartmentService  extends ABaseService<Department> implements IDepartmentService{

	
	@Autowired
	public IDepartmentRepository repository;



	@Override
	protected IBaseRepository<Department, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}

