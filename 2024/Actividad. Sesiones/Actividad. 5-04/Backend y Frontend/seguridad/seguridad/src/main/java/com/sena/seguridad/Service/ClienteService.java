package com.sena.seguridad.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IClienteRepository;
import com.sena.seguridad.IService.IClienteService;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService{

    @Override
    protected IBaseRepository<Cliente, Long> getRepository() {
		// TODO Auto-generated constructor stub
        return repository;
    }

    @Autowired
    public IClienteRepository repository;
    
}
