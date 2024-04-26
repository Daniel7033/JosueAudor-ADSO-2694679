package com.sena.seguridad.DTO.Compañia;

import com.sena.seguridad.DTO.IGenericDto;

public interface IEmployedDto extends IGenericDto{
	
	String getCode();
	String getPerson();
	String getPosition();
	String getCompany();
}
