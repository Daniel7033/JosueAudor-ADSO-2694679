package com.sena.biblioteca.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.backend.Entity.Registro;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IRepository.IRegistroRepository;
import com.sena.biblioteca.backend.IService.IRegistroService;

@Service 
public class RegistroService extends ABaseService<Registro> implements IRegistroService{

    @Override
	protected IBaseRepository<Registro, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private IRegistroRepository repository;
    
}
