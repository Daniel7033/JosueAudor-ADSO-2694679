package com.sena.seguridad.Service.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.seguridad.Entity.View;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Seguridad.IViewRepository;
import com.sena.seguridad.IService.Seguridad.IViewService;
import com.sena.seguridad.Service.ABaseService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{

	@Override
	protected IBaseRepository<View, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IViewRepository repository;

	
	
	
}