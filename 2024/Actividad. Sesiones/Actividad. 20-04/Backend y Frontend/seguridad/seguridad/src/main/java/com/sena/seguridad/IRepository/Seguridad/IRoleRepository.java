package com.sena.seguridad.IRepository.Seguridad;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Role;
import com.sena.seguridad.IRepository.IBaseRepository;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long>{

}
