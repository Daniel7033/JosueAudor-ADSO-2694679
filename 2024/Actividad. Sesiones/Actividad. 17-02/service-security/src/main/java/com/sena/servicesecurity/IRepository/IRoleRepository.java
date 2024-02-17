package com.sena.servicesecurity.IRepository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.Entity.Role;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long>{

}
