package com.sena.ubicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ubicacion.Entity.Ciudad;
import com.sena.ubicacion.IRepository.ICiudadRepository;
import com.sena.ubicacion.IService.ICiudadService;

@Service
public class CiudadService implements ICiudadService{

	@Autowired
	private ICiudadRepository repository;
	
	@Override
	public List<Ciudad> findAll() {
		return repository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Optional<Ciudad> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Ciudad save(Ciudad ciudad) {
		ciudad.setFechaCreacion(LocalDateTime.now());
		return repository.save(ciudad);
	}

	@SuppressWarnings("null")
	@Override
	public void update(Ciudad ciudad, Long id) {
		//Consultar si existe el registro
				Optional<Ciudad> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					Ciudad updateCiudad = op.get();					
					updateCiudad.setCodigo(ciudad.getCodigo());
					updateCiudad.setNombre(ciudad.getNombre());
					updateCiudad.setDepartamentoId(ciudad.getDepartamentoId());
					updateCiudad.setEstado(ciudad.getEstado());
					updateCiudad.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updateCiudad);
				}
	}
	
	@SuppressWarnings("null")
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Ciudad> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Ciudad updateCiudad = op.get();					
			updateCiudad.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateCiudad);
		}	
		
	}

	@SuppressWarnings("null")
	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

}

