package com.sena.seguridad.Service.Biblioteca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.Biblioteca.RegistroDto;
import com.sena.seguridad.Entity.Registro;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Biblioteca.IRegistroRepository;
import com.sena.seguridad.IService.Biblioteca.IRegistroService;
import com.sena.seguridad.Service.ABaseService;

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

	@Override
	public List<RegistroDto> getCantidadLibros() {
		return repository.getCantidadLibros();
	}
    
}
