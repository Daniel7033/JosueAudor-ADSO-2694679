package com.sena.seguridad.IService.Seguridad;

import java.util.List;

import com.sena.seguridad.DTO.Seguridad.IPersonDto;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IService.IBaseService;

public interface IPersonService extends IBaseService<Person>{
	
	List<IPersonDto> getList();
	
	List<IPersonDto> getDocumentByType(String typeDocument) throws Exception;
	
	public void updatePersonCliente(Long personId, Person person) throws Exception ;
	
}
