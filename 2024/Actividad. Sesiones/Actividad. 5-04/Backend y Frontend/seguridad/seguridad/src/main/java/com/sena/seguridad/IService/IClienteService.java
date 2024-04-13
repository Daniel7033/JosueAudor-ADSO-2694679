package com.sena.seguridad.IService;

import java.time.LocalDateTime;
import java.util.List;

import com.sena.seguridad.DTO.IClienteDTO;
import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.Entity.Person;

public interface IClienteService extends IBaseService<Cliente>{
    
	List<IClienteDTO> searchClientData(String term);

	public String GenerateCodeCliente(Long personId, String typeDocument, String document, LocalDateTime date) throws Exception;
	
	public Cliente savePersonCustomer(Person entity) throws Exception;
}
