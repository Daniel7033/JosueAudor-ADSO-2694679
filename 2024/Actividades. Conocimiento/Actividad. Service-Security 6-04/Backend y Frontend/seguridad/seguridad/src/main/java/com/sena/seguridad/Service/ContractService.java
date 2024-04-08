package com.sena.seguridad.Service;


import com.sena.seguridad.Entity.Contract;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IContractRepository;
import com.sena.seguridad.IService.IContractService;

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
