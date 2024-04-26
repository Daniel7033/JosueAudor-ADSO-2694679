package com.sena.seguridad.Service.Biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Libro;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Biblioteca.ILibroRepository;
import com.sena.seguridad.IService.Biblioteca.ILibroService;
import com.sena.seguridad.Service.ABaseService;

@Service 
public class LibroService extends ABaseService<Libro> implements ILibroService{

    @Override
	protected IBaseRepository<Libro, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private ILibroRepository repository;

	@Override
	public Integer obtenerCantidadTotalDeLibros() {
		return repository.getTotalLibrosDisponibles();
	}

}
