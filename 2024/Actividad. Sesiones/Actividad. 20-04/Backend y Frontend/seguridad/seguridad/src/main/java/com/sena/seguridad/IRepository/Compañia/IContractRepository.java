package com.sena.seguridad.IRepository.Compañia;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Contract;
import com.sena.seguridad.IRepository.IBaseRepository;

@Repository
public interface IContractRepository extends IBaseRepository<Contract, Long>{

	
}
