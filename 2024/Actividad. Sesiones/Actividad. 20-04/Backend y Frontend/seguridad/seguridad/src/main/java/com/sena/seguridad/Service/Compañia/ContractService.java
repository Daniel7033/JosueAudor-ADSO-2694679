package com.sena.seguridad.Service.Compañia;


import com.sena.seguridad.Entity.Contract;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Compañia.IContractRepository;
import com.sena.seguridad.IService.Compañia.IContractService;
import com.sena.seguridad.Service.ABaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService extends ABaseService<Contract> implements IContractService{

	@Override
	protected IBaseRepository<Contract, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Autowired
	private IContractRepository repository;
	

}
