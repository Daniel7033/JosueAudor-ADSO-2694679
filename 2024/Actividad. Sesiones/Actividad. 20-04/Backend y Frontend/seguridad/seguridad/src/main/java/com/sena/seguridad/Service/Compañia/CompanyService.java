package com.sena.seguridad.Service.Compañia;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Company;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Compañia.ICompanyRepository;
import com.sena.seguridad.IService.Compañia.ICompanyService;
import com.sena.seguridad.Service.ABaseService;

@Service
public class CompanyService extends ABaseService<Company> implements ICompanyService{

	@Override
	protected IBaseRepository<Company, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private ICompanyRepository repository;

}
