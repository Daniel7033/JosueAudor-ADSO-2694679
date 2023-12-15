package com.sena.ubicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ubicacion.Entity.Departamento;
import com.sena.ubicacion.IRepository.IDepartamentoRepository;
import com.sena.ubicacion.IService.IDepartamentoService;

@Service
public class DepartamentoService implements IDepartamentoService{

	@Autowired
	private IDepartamentoRepository repository;
	
	@Override
	public List<Departamento> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Departamento> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Departamento save(Departamento departamento) {
		departamento.setFechaCreacion(LocalDateTime.now());
		return repository.save(departamento);
	}

	@Override
	public void update(Departamento departamento, Long id) {
		//Consultar si existe el registro
				Optional<Departamento> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					Departamento updateDepartamento = op.get();					
					updateDepartamento.setCodigo(departamento.getCodigo());
					updateDepartamento.setNombre(departamento.getNombre());
					updateDepartamento.setPaisId(departamento.getPaisId());
					updateDepartamento.setEstado(departamento.getEstado());
					updateDepartamento.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updateDepartamento);
				}
	}
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Departamento> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Departamento updateDepartamento = op.get();					
			updateDepartamento.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateDepartamento);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

}

