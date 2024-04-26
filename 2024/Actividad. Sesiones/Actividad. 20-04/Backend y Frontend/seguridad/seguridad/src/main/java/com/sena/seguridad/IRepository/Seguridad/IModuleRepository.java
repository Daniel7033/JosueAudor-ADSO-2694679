package com.sena.seguridad.IRepository.Seguridad;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Module;
import com.sena.seguridad.IRepository.IBaseRepository;
@Repository
public interface IModuleRepository extends IBaseRepository<Module, Long>{

	
}
