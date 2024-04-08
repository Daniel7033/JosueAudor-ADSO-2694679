package com.sena.seguridad.IService;

import java.util.List;

import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Person;

public interface IPersonService extends IBaseService<Person>{
	
	List<IPersonDto> getList();
	
	List<IPersonDto> getDocumentByType(String typeDocument) throws Exception;
	

}
