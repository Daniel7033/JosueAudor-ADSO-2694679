package com.sena.servicesecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.View;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IViewRepository;
import com.sena.servicesecurity.IService.IViewService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{

	@Override
	protected IBaseRepository<View, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IViewRepository repository;

}
