package com.sena.seguridad.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Long>{
    
}
