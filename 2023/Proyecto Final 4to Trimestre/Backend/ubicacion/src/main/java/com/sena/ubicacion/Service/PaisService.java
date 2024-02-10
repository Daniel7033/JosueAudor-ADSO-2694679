package com.sena.ubicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ubicacion.Entity.Pais;
import com.sena.ubicacion.IRepository.IPaisRepository;
import com.sena.ubicacion.IService.IPaisService;

@Service
public class PaisService implements IPaisService{

	@Autowired
	private IPaisRepository repository;
	
	@Override
	public List<Pais> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Pais> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Pais save(Pais pais) {
		pais.setFechaCreacion(LocalDateTime.now());
		return repository.save(pais);
	}

	@Override
	public void update(Pais pais, Long id) {
		//Consultar si existe el registro
				Optional<Pais> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					Pais updatePais = op.get();					
					updatePais.setCodigo(pais.getCodigo());
					updatePais.setNombre(pais.getNombre());
					updatePais.setContinenteId(pais.getContinenteId());
					updatePais.setEstado(pais.getEstado());
					updatePais.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updatePais);
				}
	}
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Pais> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Pais updatePais = op.get();					
			updatePais.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updatePais);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

}

