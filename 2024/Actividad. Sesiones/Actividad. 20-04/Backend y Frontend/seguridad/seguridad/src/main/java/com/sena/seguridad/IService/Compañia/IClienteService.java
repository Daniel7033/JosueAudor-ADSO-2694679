package com.sena.seguridad.IService.Compañia;

import java.util.List;

import com.sena.seguridad.DTO.Compañia.IClienteDTO;
import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IService.IBaseService;

public interface IClienteService extends IBaseService<Cliente>{
    
	
	List<IClienteDTO> getList();
	
	public void update(Long id, Cliente entity) throws Exception;

	public Cliente savePersonCustomer(Person entity) throws Exception;

	String GenerateCodeCliente(Long personId, String typeDocument, String document)throws Exception;

	Cliente findByPersonId(Long personId) throws	Exception;

	void updatePerson(Long personId, Person entity) throws Exception;
}