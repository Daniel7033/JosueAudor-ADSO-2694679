package com.sena.seguridad.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Company;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.ICompanyRepository;
import com.sena.seguridad.IService.ICompanyService;

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
